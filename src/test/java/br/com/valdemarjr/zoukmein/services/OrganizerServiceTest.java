package br.com.valdemarjr.zoukmein.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.valdemarjr.zoukmein.domain.persons.Organizer;
import br.com.valdemarjr.zoukmein.repositories.OrganizerRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrganizerServiceTest {

  private static final long ID = 1L;
  @InjectMocks private OrganizerService service;

  @Mock private OrganizerRepository repository;

  @Test
  void create() {
    var organizer = mock(Organizer.class);
    when(repository.save(organizer)).thenReturn(organizer);

    service.create(organizer);

    verify(repository).save(organizer);
  }

  @Test
  void findByIdEmpty() {
    when(repository.findById(ID)).thenReturn(Optional.empty());

    var organizer = service.findBy(ID);

    verify(repository).findById(ID);
    Assertions.assertThat(organizer).isEmpty();
  }

  @Test
  void findByIdOk() {
    var organizerMock = mock(Organizer.class);
    when(repository.findById(ID)).thenReturn(Optional.of(organizerMock));

    var organizer = service.findBy(ID);

    verify(repository).findById(ID);
    Assertions.assertThat(organizer).isNotEmpty();
  }
}
