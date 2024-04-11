package br.com.valdemarjr.zoukmein.controllers.requests;

import br.com.valdemarjr.zoukmein.domain.address.State;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressRequestTest {

  private static final String STREET = "street";
  private static final String ZIP_CODE = "zipCode";
  private static final String NUMBER = "number";
  private static final String CITY = "city";

  @Test
  void toEntity() {
    var entity = new AddressRequest(STREET, ZIP_CODE, NUMBER, CITY, State.SC).toEntity();
    Assertions.assertThat(entity.getStreet()).isEqualTo(STREET);
    Assertions.assertThat(entity.getZipCode()).isEqualTo(ZIP_CODE);
    Assertions.assertThat(entity.getNumber()).isEqualTo(NUMBER);
    Assertions.assertThat(entity.getCity()).isEqualTo(CITY);
    Assertions.assertThat(entity.getState()).isEqualTo(State.SC);
  }
}
