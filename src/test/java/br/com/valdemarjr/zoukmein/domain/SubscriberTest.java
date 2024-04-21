package br.com.valdemarjr.zoukmein.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SubscriberTest {

  private static final String EMAIL = "email@email.com";
  private static final String NAME = "Subscriber";

  @Test
  void constructor() {
    var subscriber = new Subscriber(NAME, EMAIL);
    Assertions.assertThat(subscriber.getName()).isEqualTo(NAME);
    Assertions.assertThat(subscriber.getEmail()).isEqualTo(EMAIL);
    Assertions.assertThat(subscriber.getActive()).isFalse();
    Assertions.assertThat(subscriber.getCreatedAt()).isNull();
  }
}
