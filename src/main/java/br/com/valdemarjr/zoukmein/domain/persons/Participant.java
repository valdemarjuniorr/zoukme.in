package br.com.valdemarjr.zoukmein.domain.persons;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participant")
public class Participant extends Person {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participant_gen")
  @SequenceGenerator(name = "participant_gen", sequenceName = "participant_seq")
  private Long id;
}
