package br.com.valdemarjr.zoukmein.domain.persons;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist extends Person {

  @Column(name = "description", nullable = false)
  private String description;
}
