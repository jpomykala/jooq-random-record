package com.jpomykala.jooq.random.handlers;

import com.jpomykala.jooq.random.ClassRequest;
import com.jpomykala.jooq.random.ClassResponse;
import com.jpomykala.jooq.random.RandomTypeHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Jakub Pomykala on 4/12/18.

 */
public class TimestampRandomTypeHandler implements RandomTypeHandler {

  @Override
  public boolean supports(Class clazz) {
    return clazz.isAssignableFrom(Timestamp.class);
  }

  @Override
  public ClassResponse handle(ClassRequest classRequest) {
    long nextInt = ThreadLocalRandom.current().nextInt(10);
    LocalDateTime localDateTime = LocalDateTime.now().minusDays(nextInt);
    return ClassResponse.ofHandled(Timestamp.valueOf(localDateTime));
  }

  @Override
  public int getOrder() {
    return 0;
  }

}
