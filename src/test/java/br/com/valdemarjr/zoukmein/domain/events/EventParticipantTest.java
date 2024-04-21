package br.com.valdemarjr.zoukmein.domain.events;

import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EventParticipantTest {

  @Test
  void constructor() {
    var event = Mockito.mock(Event.class);
    var participant1 = Mockito.mock(Participant.class);

    var eventParticipant = new EventParticipant(event, participant1, Decision.GOING);

    Assertions.assertThat(eventParticipant.getEvent()).isEqualTo(event);
    Assertions.assertThat(eventParticipant.getParticipant()).isEqualTo(participant1);
    Assertions.assertThat(eventParticipant.getDecision()).isEqualTo(Decision.GOING);
  }
}
