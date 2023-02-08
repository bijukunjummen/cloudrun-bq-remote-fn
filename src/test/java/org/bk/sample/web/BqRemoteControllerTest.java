package org.bk.sample.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bk.sample.model.BqRequest;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.InputStream;

@WebFluxTest(BqRemoteController.class)
class BqRemoteControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void fnWithPayload() throws Exception {
        InputStream inputStream = BqRemoteControllerTest.class.getResourceAsStream("/request-sample.json");
        BqRequest bqRequest = objectMapper.readValue(inputStream, BqRequest.class);
        webTestClient.post()
                .uri("/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(bqRequest)
                .exchange()
                .expectBody()
                .jsonPath("$.replies[0]").isEqualTo("The quick brown fox jumps over the lazy dog");
    }
}
