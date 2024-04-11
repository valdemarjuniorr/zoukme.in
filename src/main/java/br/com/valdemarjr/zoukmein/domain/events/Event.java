package br.com.valdemarjr.zoukmein.domain.events;

import br.com.valdemarjr.zoukmein.domain.SocialMedia;
import br.com.valdemarjr.zoukmein.domain.address.Address;
import br.com.valdemarjr.zoukmein.domain.persons.Artist;
import br.com.valdemarjr.zoukmein.domain.persons.Organizer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "event")
public class Event {

  @Id
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_gen")
  @SequenceGenerator(name = "event_gen", sequenceName = "event_seq")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private LocalDateTime startDate;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private EventType type;

  @OneToOne
  @JoinColumn(nullable = false)
  private Organizer organizer;

  @JoinColumn
  @OneToOne(cascade = CascadeType.PERSIST)
  private SocialMedia socialMedia;

  @JoinColumn
  @OneToOne(cascade = CascadeType.PERSIST)
  private Address address;

  @ManyToMany private List<Artist> artists;
}
