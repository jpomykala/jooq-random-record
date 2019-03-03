package com.jpomykala.jooq.random;

import com.google.common.collect.Lists;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Jakub Pomykala on 4/12/18.
 */
public class RandomJooq {

  private static List<RandomTypeHandler> handlers = Collections.emptyList();

  private RandomJooq() {
  }

  private static void tryLoadHandlers() {
    try {
      handlers = loadHandlers();
    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
      e.printStackTrace();
      handlers = Collections.emptyList();
    }
  }

  public static <T> List<T> randomizeList(int amount, Class<T> clazz, Function<T, T> supplier) {
    List<T> list = randomizeList(amount, clazz);

    for (T item : list) {
      supplier.apply(item);
    }
    return list;
  }

  public static <T> List<T> randomizeList(int amount, Class<T> clazz) {
    List<T> output = new ArrayList<>();
    for (int i = 0; i < amount; i++) {
      T randomize = randomize(clazz);
      output.add(randomize);
    }
    return output;
  }

  public static <T> T randomize(Class<T> clazz) {
    Constructor maxParameterConstructor = getMaxParameterConstructor(clazz);
    Parameter[] parameters = maxParameterConstructor.getParameters();

    List<Object> initArgs = new ArrayList<>();
    for (Parameter parameter : parameters) {
      Class<?> type = parameter.getType();

      RandomTypeHandler handler = lookupHandler(type);
      ClassRequest classRequest = ClassRequest.of(type);
      ClassResponse classResponse = handler.handle(classRequest);
      initArgs.add(classResponse.getValue());
    }

    return createInstance(maxParameterConstructor, initArgs);
  }

  private static RandomTypeHandler lookupHandler(Class<?> clazz) {
    if (handlers.isEmpty()) {
      tryLoadHandlers();
    }

    return handlers.stream()
            .sorted(Comparator.comparingInt(RandomTypeHandler::getOrder).reversed())
            .filter(randomTypeHandler -> randomTypeHandler.supports(clazz))
            .findFirst()
            .orElseThrow(throwIllegalClass(clazz));
  }

  private static List<RandomTypeHandler> loadHandlers()
          throws IllegalAccessException, InvocationTargetException, InstantiationException {
    List<RandomTypeHandler> handlers = Lists.newArrayList();
    Reflections reflections = new Reflections("com.jpomykala.jooq.random");
    Set<Class<? extends RandomTypeHandler>> classes = reflections.getSubTypesOf(RandomTypeHandler.class);
    for (Class<? extends RandomTypeHandler> handlerClass : classes) {
      Constructor<?>[] constructors = handlerClass.getConstructors();
      Constructor<?> constructor = constructors[0];
      Object handler = constructor.newInstance();
      handlers.add((RandomTypeHandler) handler);
    }
    return handlers;
  }

  private static Supplier<IllegalArgumentException> throwIllegalClass(Class<?> clazz) {
    String exceptionMessage = "Cannot find proper handler for class " + clazz.getSimpleName();
    return () -> new IllegalArgumentException(exceptionMessage);
  }

  @SuppressWarnings("unchecked")
  private static <T> T createInstance(Constructor maxParameterConstructor, List<Object> initArgs) {
    try {
      return (T) maxParameterConstructor.newInstance(initArgs.toArray());
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new IllegalArgumentException("Cannot cast back your class");
    }
  }

  private static Constructor getMaxParameterConstructor(Class clazz) {
    Constructor[] constructors = clazz.getConstructors();
    int maxParameterCount = 0;
    for (Constructor constructor : constructors) {
      int parameterCount = constructor.getParameterCount();
      if (parameterCount > maxParameterCount) {
        maxParameterCount = parameterCount;
      }
    }

    for (Constructor constructor : constructors) {
      int parameterCount = constructor.getParameterCount();
      if (maxParameterCount == parameterCount) {
        return constructor;
      }
    }
    throw new IllegalArgumentException();
  }
}
