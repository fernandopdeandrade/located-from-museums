package com.betrybe.museumfinder.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.CollectionTypeService;
import com.betrybe.museumfinder.service.MuseumService;

@SpringBootTest
@DisplayName(value = "Testando a classe CollectionTypeService e a classe museumService")
public class CollectionTypeServiceTest {

  @MockBean
  MuseumFakeDatabase database;

  @Autowired
  CollectionTypeService collectionTypeService;

  @Autowired
  MuseumService museumService;

  @Test
  @DisplayName("01 - Testando a classse MuseumService com o método getMuseum() que recebe um id!")
  void testeCountByCollectionTypes() {
 
    Museum mockMuseum = new Museum(
        1L,
        "Museu #1",
        "Descrição #1",
        "Endereço #1",
        "Tipo #1",
        "Assunto #1",
        "url #1",
        new Coordinate(-11.111, -22.222), null
    );

    Mockito.when(database.getMuseum(any())).thenReturn(
      Optional.of(mockMuseum)
    );

    Long id = mockMuseum.getId();

    Optional<Museum> museum = museumService.getMuseum(id);

    assertNotNull(museum);

    assertEquals("Museu #1", museum.get().getName());
    assertEquals("Descrição #1", museum.get().getDescription());
    assertEquals("Endereço #1", museum.get().getAddress());
    assertEquals("Tipo #1", museum.get().getCollectionType());
    assertEquals("Assunto #1", museum.get().getSubject());
    assertEquals("url #1", museum.get().getUrl());
    assertEquals(-11.111, museum.get().getCoordinate().latitude());
    assertEquals(-22.222, museum.get().getCoordinate().longitude());

    Mockito.verify(database).getMuseum(eq(id));
  }
  
  @Test
  @DisplayName("02 - Testando o método splitTypesByComma()")
  void testSplitTypesByComma() {

    String[] collectionTypes = { "Arqueologia", "Arte", "Ciências Naturais", "História" };

    collectionTypeService.countByCollectionTypes(collectionTypes[1]);

    assertEquals(4, collectionTypes.length);
    assertEquals("Arte", collectionTypes[1]);
  }

  @Test
  @DisplayName("03 - Testando o método countByCollectionTypes()")
  void testCountByCollectionTypes() {

    String collectionTypes = "Arte";

    collectionTypeService.countByCollectionTypes(collectionTypes);

    assertEquals(4, collectionTypes.length());
    assertEquals("Arte", collectionTypes);
  }
}
