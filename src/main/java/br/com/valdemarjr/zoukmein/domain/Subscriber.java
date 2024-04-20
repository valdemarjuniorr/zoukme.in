package br.com.valdemarjr.zoukmein.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscriber")
public class Subscriber {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscriber_gen")
  @SequenceGenerator(name = "subscriber_gen", sequenceName = "subscriber_seq")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private Boolean active;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime createdAt;
}
