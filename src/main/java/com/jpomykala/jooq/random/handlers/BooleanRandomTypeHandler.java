package com.jpomykala.jooq.random.handlers;

import com.jpomykala.jooq.random.ClassRequest;
import com.jpomykala.jooq.random.ClassResponse;
import com.jpomykala.jooq.random.RandomTypeHandler;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Jakub Pomykala on 4/12/18.

 */
public class BooleanRandomTypeHandler implements RandomTypeHandler {

  @Override
  public boolean supports(Class clazz) {
    return clazz.isAssignableFrom(Boolean.class);
  }

  @Override
  public ClassResponse handle(ClassRequest classRequest) {
    boolean next = ThreadLocalRandom.current().nextBoolean();
    return ClassResponse.ofHandled(next);
  }

  @Override
  public int getOrder() {
    return 0;
  }

}
