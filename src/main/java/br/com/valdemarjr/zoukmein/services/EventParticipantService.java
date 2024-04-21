package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.events.Decision;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.domain.events.EventParticipant;
import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import br.com.valdemarjr.zoukmein.exceptions.EventNotFoundException;
import br.com.valdemarjr.zoukmein.exceptions.ParticipantNotFoundException;
import br.com.valdemarjr.zoukmein.repositories.EventParticipantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventParticipantService {

  private final EventParticipantRepository repository;
  private final EventService eventService;
  private final ParticipantService participantService;

  public void decide(Event event, Participant participant, Decision decision) {
    event = eventService.findBy(event.getId()).orElseThrow(EventNotFoundException::new);
    participant =
        participantService
            .findBy(participant.getId())
            .orElseThrow(ParticipantNotFoundException::new);
    var eventParticipant = new EventParticipant(event, participant, decision);

    repository.save(eventParticipant);
    log.info("User {} decided {} to the event {}", participant.getId(), decision, event.getId());
  }
}
