package com.betrybe.museumfinder.evaluation;

import static com.betrybe.museumfinder.evaluation.utils.TestHelpers.createMockMuseum;
import static com.betrybe.museumfinder.evaluation.utils.TestHelpers.objectToJson;
import static com.betrybe.museumfinder.util.ModelDtoConverter.modelToDto;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Req 05-06")
class ControllerLayerTest {

  @MockBean
  MuseumServiceInterface museumsServiceInterface;

  @Autowired
  MockMvc mockMvc;

@Test
@DisplayName("05 - Rota POST /museums implementada")
void museumCreation() throws Exception {
    Museum museum = createMockMuseum(33L);
    Mockito.when(museumsServiceInterface.createMuseum(any())).thenReturn(museum);

    MuseumDto toSaveMuseum = modelToDto(createMockMuseum(null));
    String content = objectToJson(toSaveMuseum);

    if (content != null) {
      MediaType mediaType = MediaType.APPLICATION_JSON;
      if (mediaType != null) {
        mockMvc.perform(post("/museums")
            .contentType(mediaType)
            .content(content))
          .andExpect(status().isCreated())
          .andExpect(content().contentType(mediaType))
          .andExpect(jsonPath("$.name").value(museum.getName()))
          .andExpect(jsonPath("$.address").value(museum.getAddress()))
          .andExpect(jsonPath("$.description").value(museum.getDescription()))
          .andExpect(jsonPath("$.collectionType").value(museum.getCollectionType()))
          .andExpect(jsonPath("$.subject").value(museum.getSubject()))
          .andExpect(jsonPath("$.url").value(museum.getUrl()))
          .andExpect(jsonPath("$.coordinate.latitude").value(museum.getCoordinate().latitude()))
          .andExpect(jsonPath("$.coordinate.longitude").value(museum.getCoordinate().longitude()));
      }
    } else {
        throw new IllegalStateException("Content cannot be null");
    }

    Mockito.verify(museumsServiceInterface).createMuseum(any());
}

@Test
@DisplayName("06 - Rota GET /museums/closest implementada")
void getClosestMuseum() throws Exception {
    Museum museum = createMockMuseum(11L);
    Mockito.when(museumsServiceInterface.getClosestMuseum(any(), any())).thenReturn(museum);

    if (MediaType.APPLICATION_JSON != null) {
      MediaType mediaType = MediaType.APPLICATION_JSON;
      mockMvc.perform(
        get("/museums/closest?lat=12.34&lng=23.45&max_dist_km=10")
        .accept(mediaType)
      )
      .andExpect(status().isOk())
      .andExpect(content().contentType(mediaType))
      .andExpect(jsonPath("$.name").value(museum.getName()))
      .andExpect(jsonPath("$.coordinate.latitude").value(museum.getCoordinate().latitude()))
      .andExpect(jsonPath("$.coordinate.longitude").value(museum.getCoordinate().longitude()));

      Mockito.verify(museumsServiceInterface).getClosestMuseum(any(), any());
    } else {
        // Trate o caso em que MediaType.APPLICATION_JSON é null
        throw new IllegalStateException("MediaType.APPLICATION_JSON cannot be null");
    }

    Mockito.reset(museumsServiceInterface);
 }
}
