package br.com.valdemarjr.zoukmein.controllers.events;

import br.com.valdemarjr.zoukmein.controllers.participants.ParticipantRequest;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import br.com.valdemarjr.zoukmein.services.EventParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events/{eventId}/participants/{participantId}")
public class EventParticipantController {

  private final EventParticipantService service;

  @PostMapping("/decide")
  void decide(
      @PathVariable Long eventId, @PathVariable Long participantId, ParticipantRequest request) {
    var event = Event.builder().id(eventId).build();
    var participant = Participant.builder().id(participantId).build();
    service.decide(event, participant, request.decision());
  }
}
