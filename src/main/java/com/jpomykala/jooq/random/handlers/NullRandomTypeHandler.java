package com.jpomykala.jooq.random.handlers;


import com.jpomykala.jooq.random.ClassRequest;
import com.jpomykala.jooq.random.ClassResponse;
import com.jpomykala.jooq.random.RandomTypeHandler;

/**
 * @author Jakub Pomykala on 4/12/18.
 * @project vending-backend
 */
public class NullRandomTypeHandler implements RandomTypeHandler {

  @Override
  public ClassResponse handle(ClassRequest classRequest) {
    return ClassResponse.ofHandled(null);
  }

  @Override
  public boolean supports(Class clazz) {
    return true;
  }

  @Override
  public int getOrder() {
    return Integer.MIN_VALUE;
  }
}
