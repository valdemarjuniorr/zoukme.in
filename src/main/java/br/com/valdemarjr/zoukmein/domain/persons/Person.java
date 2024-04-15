package br.com.valdemarjr.zoukmein.domain.persons;

import br.com.valdemarjr.zoukmein.domain.SocialMedia;
import br.com.valdemarjr.zoukmein.domain.assets.Photo;
import jakarta.persistence.CascadeType;
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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.util.CollectionUtils;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_gen")
  @SequenceGenerator(name = "person_gen", sequenceName = "person_seq")
  @Column(name = "id", nullable = false)
  protected Long id;

  @Column(name = "name", nullable = false)
  protected String name;

  @Column(name = "email", nullable = false)
  protected String email;

  @Column(name = "mobile", nullable = false)
  protected String mobile;

  @OneToOne(cascade = CascadeType.PERSIST)
  protected SocialMedia socialMedia;

  @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
  protected List<Photo> photos;

  public String firstPhoto() {
    return !CollectionUtils.isEmpty(this.photos) ? this.photos.getFirst().getUrl() : "";
  }
}
