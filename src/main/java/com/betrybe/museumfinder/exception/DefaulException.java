package com.betrybe.museumfinder.exception;

public class DefaulException extends  RuntimeException{

  public DefaulException () {
  }

  public DefaulException (String message) {
    super(message);
  }

  public DefaulException (String message, Throwable cause) {
    super(message, cause);
  }

  public DefaulException (Throwable cause) {
    super(cause);
  }

  public DefaulException (String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
