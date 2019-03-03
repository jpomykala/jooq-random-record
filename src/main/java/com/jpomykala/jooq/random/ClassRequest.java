package com.jpomykala.jooq.random;


/**
 * @author Jakub Pomykala on 4/12/18.
 * @project vending-backend
 */
public class ClassRequest {

  private Class<?> clazz;

  private boolean handled = false;


  private ClassRequest(Class<?> clazz) {
    this.clazz = clazz;
  }

  public static ClassRequest of(Class<?> clazz) {
    return new ClassRequest(clazz);
  }

  public Class<?> getClazz() {
    return clazz;
  }

  public boolean isHandled() {
    return handled;
  }
}
