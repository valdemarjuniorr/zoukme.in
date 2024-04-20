package br.com.valdemarjr.zoukmein.controllers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SubscriberRequestTest {

  @Test
  void toEntity() {
    var request = new SubscriberRequest("User", "email@email.com");
    var entity = request.toEntity();
    Assertions.assertThat(entity.getName()).isEqualTo(request.name());
    Assertions.assertThat(entity.getEmail()).isEqualTo(request.email());
    Assertions.assertThat(entity.getActive()).isFalse();
  }
}
