package br.com.valdemarjr.zoukmein.controllers.events;

import br.com.valdemarjr.zoukmein.AbstractIntegrationTest;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

class EventControllerTest extends AbstractIntegrationTest {

  private RestClient restClient = RestClient.builder().baseUrl("/events").build();

  @Test
  void findByIdNotFound() {
    var notFound =
        restClient
            .get()
            .uri(getServerPort() + "/{id}", 1)
            .retrieve()
            .onStatus(
                HttpStatusCode::is4xxClientError,
                (request, response) ->
                    Assertions.assertThat(response.getStatusText()).isEqualTo("Not Found"))
            .body(Event.class);

    Assertions.assertThat(notFound).isNotNull();
  }
}
