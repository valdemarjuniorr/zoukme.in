package br.com.valdemarjr.zoukmein.domain.persons;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "artist")
public class Artist extends Person {

  @Column(name = "description", nullable = false)
  private String description;

  public String firstPhoto() {
    return !CollectionUtils.isEmpty(this.photos) ? this.photos.getFirst().getUrl() : "";
  }
}
