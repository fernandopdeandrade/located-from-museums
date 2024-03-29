package com.betrybe.museumfinder.model;

/**
 * The type Museum.
 */
public class Museum {
  private Long id;
  private String name;
  private String description;
  private String address;
  private String collectionType;
  private String subject;
  private String url;
  private Coordinate coordinate;
  private Long legacyId;

  /**
   * Instantiates a new Museum.
   */
  public Museum() {
  }

  /**
   * Instantiates a new Museum.
   *
   * @param id             the id
   * @param name           the name
   * @param description    the description
   * @param address        the address
   * @param collectionType the collection type
   * @param subject        the subject
   * @param url            the url
   * @param coordinate     the coordinate
   * @param legacyId       the legacyId
   */
  public Museum(
      Long id,
      String name,
      String description,
      String address,
      String collectionType,
      String subject,
      String url,
      Coordinate coordinate,
      Long legacyId
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.address = address;
    this.collectionType = collectionType;
    this.subject = subject;
    this.url = url;
    this.coordinate = coordinate;
    this.legacyId = legacyId;
  }

  /**
   * Instantiates a new Museum.
   *
   * @param name           the name
   * @param description    the description
   * @param address        the address
   * @param collectionType the collection type
   * @param subject        the subject
   * @param url            the url
   * @param coordinate     the coordinate
   */
  public Museum (
      String name,
      String description,
      String address,
      String collectionType,
      String subject, String
      url, Coordinate coordinate
  ) {
    this.name = name;
    this.description = description;
    this.address = address;
    this.collectionType = collectionType;
    this.subject = subject;
    this.url = url;
    this.coordinate = coordinate;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets collection type.
   *
   * @return the collection type
   */
  public String getCollectionType() {
    return collectionType;
  }

  /**
   * Sets collection type.
   *
   * @param collectionType the collection type
   */
  public void setCollectionType(String collectionType) {
    this.collectionType = collectionType;
  }

  /**
   * Gets subject.
   *
   * @return the subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Sets subject.
   *
   * @param subject the subject
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Gets url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets url.
   *
   * @param url the url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Gets coordinate.
   *
   * @return the coordinate
   */
  public Coordinate getCoordinate() {
    return coordinate;
  }

  /**
   * Sets coordinate.
   *
   * @param coordinate the coordinate
   */
  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  /**
   * Gets legacy.
   *
   * @return the legacy
   */
  public Long getLegacyId() {
    return legacyId;
  }

  /**
   * Sets legacy.
   *
   * @param legacyId the legacy
   */
  public void setLegacyId(Long legacyId) {
    this.legacyId = legacyId;
  }
}
