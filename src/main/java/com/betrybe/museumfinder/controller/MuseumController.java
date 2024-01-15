package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
   * @param museumDtoCreationDto the museum dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody MuseumCreationDto museumDtoCreationDto) {
    Museum museumToBeSaved = museumDtoCreationDto.museumModel();
    Museum museumDtoCreate = museumService.createMuseum(museumToBeSaved);

    return ResponseEntity.status(HttpStatus.CREATED).body(museumDtoCreate);
  }
}
