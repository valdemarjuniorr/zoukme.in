package br.com.valdemarjr.zoukmein.domain.persons;

import br.com.valdemarjr.zoukmein.domain.SocialMedia;
import br.com.valdemarjr.zoukmein.domain.assets.Photo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_gen")
  @SequenceGenerator(name = "person_gen", sequenceName = "person_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "mobile", nullable = false)
  private String mobile;

  @OneToOne private SocialMedia socialMedia;

  @OneToMany(mappedBy = "person")
  private List<Photo> photos;
}
