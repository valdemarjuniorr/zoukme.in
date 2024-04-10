package br.com.valdemarjr.zoukmein.domain.address;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddressTest {

  @Test
  void fullAddressOk() {
    var address =
        Address.builder()
            .street("Centro")
            .number("123")
            .city("Joinville")
            .state(State.SC)
            .zipCode("89223005")
            .build();

    assertThat(address.fullAddress()).isEqualTo("Centro, 123 - Joinville/SC - 89223005");
  }
}
