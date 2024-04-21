package br.com.valdemarjr.zoukmein.domain.events;

import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event_participant")
public class EventParticipant {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_participant_gen")
  @SequenceGenerator(name = "event_participant_gen", sequenceName = "event_participant_seq")
  private Long id;

  @OneToOne private Participant participant;

  @OneToOne private Event event;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Decision decision;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime decidedAt;

  public EventParticipant(Event event, Participant participant, Decision decision) {
    this.event = event;
    this.participant = participant;
    this.decision = decision;
  }
}
