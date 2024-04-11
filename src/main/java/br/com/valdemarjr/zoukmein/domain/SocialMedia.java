package br.com.valdemarjr.zoukmein.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "social_media")
public class SocialMedia {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "social_media__gen")
  @SequenceGenerator(name = "social_media__gen", sequenceName = "social_media__seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column private String instagram;

  @Column private String facebook;

  @Column private String youtube;

  @Column private String webSite;
}
