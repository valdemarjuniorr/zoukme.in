package br.com.valdemarjr.zoukmein.domain.assets;

import br.com.valdemarjr.zoukmein.domain.persons.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "photo")
public class Photo {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photo_gen")
  @SequenceGenerator(name = "photo_gen", sequenceName = "photo_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column private String description;

  @Column(nullable = false)
  private String url;

  @ManyToOne private Person person;
}
