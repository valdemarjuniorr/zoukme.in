package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.events.Decision;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.domain.events.EventParticipant;
import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import br.com.valdemarjr.zoukmein.exceptions.EventNotFoundException;
import br.com.valdemarjr.zoukmein.exceptions.ParticipantNotFoundException;
import br.com.valdemarjr.zoukmein.repositories.EventParticipantRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EventParticipantServiceTest {

  private static final Long ID = 1L;
  @InjectMocks private EventParticipantService service;

  @Mock private EventParticipantRepository repository;
  @Mock private EventService eventService;
  @Mock private ParticipantService participantService;

  private Event event = Event.builder().id(ID).build();
  private Participant participant = Participant.builder().id(ID).build();

  @Test
  void eventNotFound() {
    Mockito.when(eventService.findBy(ID)).thenReturn(Optional.empty());

    Assertions.assertThatThrownBy(() -> service.decide(event, participant, Decision.MAYBE))
        .isInstanceOf(EventNotFoundException.class);

    Mockito.verifyNoInteractions(participantService, repository);
  }

  @Test
  void userNotFound() {
    Mockito.when(eventService.findBy(ID)).thenReturn(Optional.of(event));
    Mockito.when(participantService.findBy(ID)).thenReturn(Optional.empty());

    Assertions.assertThatThrownBy(() -> service.decide(event, participant, Decision.GOING))
        .isInstanceOf(ParticipantNotFoundException.class);

    Mockito.verifyNoInteractions(repository);
  }

  @Test
  void decide() {
    Mockito.when(eventService.findBy(ID)).thenReturn(Optional.of(event));
    Mockito.when(participantService.findBy(ID)).thenReturn(Optional.of((participant)));
    var eventParticipant = Mockito.mock(EventParticipant.class);

    var captor = ArgumentCaptor.forClass(EventParticipant.class);
    Mockito.when(repository.save(captor.capture())).thenReturn(eventParticipant);

    service.decide(event, participant, Decision.GOING);

    Mockito.verify(repository).save(captor.capture());
  }
}
