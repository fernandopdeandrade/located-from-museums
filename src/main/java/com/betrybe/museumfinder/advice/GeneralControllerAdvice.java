package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.exception.DefaulException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type General controller advice.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Handle invalid coordinate exception response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinateException(InvalidCoordinateException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenada inválida!");
  }

  /**
   * Handle museum not found exception response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> handleMuseumNotFoundException(MuseumNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Museu não encontrado!");
  }

  /**
   * Defaul exception response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(DefaulException.class)
  public ResponseEntity<String> defaulException(DefaulException e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno!");
  }
}
