package com.betrybe.museumfinder.exception;

/**
 * The type Museum not found exception.
 */
public class MuseumNotFoundException extends RuntimeException {

  public MuseumNotFoundException () {
  }

  public MuseumNotFoundException (String message) {
    super(message);
  }

  public MuseumNotFoundException (String message, Throwable cause) {
    super(message, cause);
  }

  public MuseumNotFoundException (Throwable cause) {
    super(cause);
  }

  public MuseumNotFoundException (String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
