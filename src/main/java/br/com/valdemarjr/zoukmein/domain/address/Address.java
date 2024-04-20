package br.com.valdemarjr.zoukmein.domain.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_gen")
  @SequenceGenerator(name = "address_gen", sequenceName = "address_seq")
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String street;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private State state;

  @Column(nullable = false)
  private String city;

  @Column private String zipCode;

  @Column(nullable = false)
  private String number;

  public String fullAddress() {
    return street + ", " + number + " - " + city + "/" + state + " - " + zipCode;
  }
}
