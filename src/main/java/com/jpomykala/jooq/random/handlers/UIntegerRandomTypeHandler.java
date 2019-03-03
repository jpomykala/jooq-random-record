package com.jpomykala.jooq.random.handlers;

import com.jpomykala.jooq.random.ClassRequest;
import com.jpomykala.jooq.random.ClassResponse;
import com.jpomykala.jooq.random.RandomTypeHandler;
import org.jooq.types.UInteger;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Jakub Pomykala on 4/12/18.
 * @project vending-backend
 */
public class UIntegerRandomTypeHandler implements RandomTypeHandler {

  @Override
  public boolean supports(Class clazz) {
    return clazz.isAssignableFrom(UInteger.class);
  }

  @Override
  public ClassResponse handle(ClassRequest classRequest) {
    long nextLong = ThreadLocalRandom.current().nextLong(100);
    return ClassResponse.ofHandled(UInteger.valueOf(nextLong));
  }

  @Override
  public int getOrder() {
    return 0;
  }

}
