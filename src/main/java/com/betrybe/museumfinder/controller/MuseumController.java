package com.betrybe.museumfinder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;

/**
 * The type Museum controller.
 */
@Controller
@RequestMapping("/museums")
public class MuseumController {

  @Autowired
  private MuseumServiceInterface museumService;

  /**
   * Create museum response entity.
   *
   * @param museumCreationDto the museum dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody MuseumCreationDto museumCreationDto) {
    Museum museumToBeSaved = museumCreationDto.museumModel();
    Museum museumDtoCreate = museumService.createMuseum(museumToBeSaved);

    return ResponseEntity.status(HttpStatus.CREATED).body(museumDtoCreate);
  }

  /**
   * Gets museum by id.
   *
   * @param id the id
   * @return the museum by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<?> getMuseumById(@PathVariable Long id) {
    Optional<Museum> museumOptional = museumService.getMuseum(id);

    if (museumOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(museumOptional);
    }

    Museum museum = museumOptional.get();

    return ResponseEntity.ok(museum);
  }

  /**
   * Gets museum closest.
   *
   * @param lat         the lat
   * @param lng         the lng
   * @param max_dist_km the max dist km
   * @return the museum closest
   */
  @GetMapping("/closest")
  public ResponseEntity<Museum> getMuseumClosest(
      @RequestParam double lat,
      @RequestParam double lng,
      @RequestParam double max_dist_km
  ) {
    try {
      Coordinate cord = new Coordinate(lat, lng);
      Museum response = museumService.getClosestMuseum(cord, max_dist_km);

      return ResponseEntity.status(HttpStatus.OK).body(response);
    }  catch (InvalidCoordinateException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Coordenada inválida!", e);
    } catch (Exception e) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno!", e);
    }
  }
}
