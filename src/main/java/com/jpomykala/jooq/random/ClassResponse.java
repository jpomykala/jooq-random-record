package com.jpomykala.jooq.random;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Jakub Pomykala on 4/12/18.

 */
@Getter
public class ClassResponse {

  @Setter
  private Object value;
  private boolean handled;

  private ClassResponse(boolean handled, Object value) {
    this.value = value;
    this.handled = handled;
  }

  public static ClassResponse ofNotHandled() {
    return new ClassResponse(false, null);
  }

  public static ClassResponse ofHandled(Object value) {
    return new ClassResponse(true, value);
  }
}
