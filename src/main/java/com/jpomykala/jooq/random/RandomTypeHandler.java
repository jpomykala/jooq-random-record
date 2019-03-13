package com.jpomykala.jooq.random;

/**
 * @author Jakub Pomykala on 4/12/18.

 */
public interface RandomTypeHandler {

  boolean supports(Class clazz);

  ClassResponse handle(ClassRequest classRequest);

  int getOrder();

}
