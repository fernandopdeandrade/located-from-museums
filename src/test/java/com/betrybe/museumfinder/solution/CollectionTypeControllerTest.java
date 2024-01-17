package com.betrybe.museumfinder.solution;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.betrybe.museumfinder.controller.CollectionTypeController;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;

@SpringBootTest
@DisplayName(value = "Testando a classe CollectionTypeController")
public class CollectionTypeControllerTest {
  
  @MockBean
  CollectionTypeService collectionTypeService;

  @Autowired
  CollectionTypeController collectionTypeController;

  @Test
  @DisplayName("01 - Testando a classe CollectionTypeController com o método countByCollectionTypes()!")
  void testeCountByCollectionTypes() {
    Mockito.when(collectionTypeService.countByCollectionTypes(any(String.class)))
        .thenReturn(new CollectionTypeCount(new String[] { "Arqueologia" }, 1));

    CollectionTypeCount result = collectionTypeController.getCollectionTypesCount("Arqueologia").getBody();

    assertNotNull(result);
  }
  
  @Test
  @DisplayName("02 - Testando a classe CollectionTypeController com o método getCollectionTypesCount() passando uma rota valida '/collections/count/história,arqueologia'!")
  void testeGetCollectionTypesCount() {
    Mockito.when(collectionTypeService.countByCollectionTypes(any(String.class)))
        .thenReturn(new CollectionTypeCount(new String[] { "História", "Arqueologia" }, 2));

    CollectionTypeCount result = collectionTypeController.getCollectionTypesCount("História, Arqueologia").getBody();

    assertNotNull(result);

    assertEquals(2, result.count());
  }
}
