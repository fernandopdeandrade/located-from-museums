package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;

/**
 * The type Museum creation dto.
 */
public record MuseumCreationDto(
    String name,
    String description,
    String address,
    String collectionType,
    String subject,
    String url,
    Coordinate coordinate
) {

  /**
   * Museum model museum.
   *
   * @return the museum
   */
  public Museum museumModel() {
    return new Museum(
        name,
        description,
        address,
        collectionType,
        subject,
        url,
        coordinate
    );
  }
}
