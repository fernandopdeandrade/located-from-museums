package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
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

  @GetMapping("/{id}")
  public ResponseEntity<?> getMuseumById(@PathVariable Long id) {
    Optional<Museum> museumOptional = museumService.getMuseum(id);

    if (museumOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(museumOptional);
    }

    Museum museum = museumOptional.get();

    return ResponseEntity.ok(museum);
  }
}
