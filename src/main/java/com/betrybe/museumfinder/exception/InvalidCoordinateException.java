package com.betrybe.museumfinder.exception;

/**
 * The type Invalid coordinate exception.
 */
public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException () {
  }

  public InvalidCoordinateException (String message) {
    super(message);
  }

  public InvalidCoordinateException (String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidCoordinateException (Throwable cause) {
    super(cause);
  }

  public InvalidCoordinateException (String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
