package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import br.com.valdemarjr.zoukmein.repositories.ParticipantRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ParticipantServiceTest {

  private static final Long ID = 1L;

  @InjectMocks private ParticipantService service;
  @Mock private ParticipantRepository repository;

  @Test
  void findByIdEmpty() {
    Mockito.when(repository.findById(ID)).thenReturn(Optional.empty());
    var participant = service.findBy(ID);

    Assertions.assertThat(participant).isEmpty();
    Mockito.verify(repository).findById(ID);
  }

  @Test
  void findById() {
    var participant = Mockito.mock(Participant.class);
    Mockito.when(repository.findById(ID)).thenReturn(Optional.of(participant));

    var participantOp = service.findBy(ID);

    Assertions.assertThat(participantOp).contains(participant);

    Mockito.verify(repository).findById(ID);
  }

  @Test
  void create() {
    var participant = Mockito.mock(Participant.class);

    service.create(participant);

    Mockito.verify(repository).save(participant);
  }
}
