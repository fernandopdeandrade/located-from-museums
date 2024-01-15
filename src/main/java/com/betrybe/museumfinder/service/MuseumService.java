package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * The type Museum service.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  /**
   * The Museum fake database.
   */
  MuseumFakeDatabase museumFakeDatabase;

  /**
   * Instantiates a new Museum service.
   *
   * @param museumFakeDatabase the museum fake database
   */
  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    // Valida as coordenadas
    if (!CoordinateUtil.isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException();
    }

    // Obtém o museu mais próximo da base de dados
    Optional<Museum> closestMuseum = museumFakeDatabase.getClosestMuseum(coordinate, maxDistance);

    // Verifica se o museu foi encontrado
    if (closestMuseum.isEmpty()) {
      throw new MuseumNotFoundException();
    }

    // Retorna o museu encontrado
    return closestMuseum.get();
  }

  @Override
  public Museum createMuseum(Museum museum) throws InvalidCoordinateException {
    if (!CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      throw new InvalidCoordinateException();
    }

    return museumFakeDatabase.saveMuseum(museum);
  }

  @Override
  public Optional<Museum> getMuseum(Long id) {
    return museumFakeDatabase.getMuseum(id);
  }
}
