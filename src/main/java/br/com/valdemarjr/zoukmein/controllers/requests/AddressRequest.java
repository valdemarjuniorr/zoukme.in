package br.com.valdemarjr.zoukmein.controllers.requests;

import br.com.valdemarjr.zoukmein.domain.address.Address;
import br.com.valdemarjr.zoukmein.domain.address.State;

public record AddressRequest(
    String street, String zipCode, String number, String city, State state) {

  public Address toEntity() {
    return Address.builder()
        .street(this.street())
        .zipCode(this.zipCode())
        .number(this.number())
        .city(this.city())
        .state(this.state())
        .build();
  }
}
