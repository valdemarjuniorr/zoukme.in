package br.com.valdemarjr.zoukmein.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.repositories.EventRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

  private static final long ID = 1L;
  @InjectMocks private EventService service;

  @Mock private EventRepository repository;

  @Test
  void create() {
    var event = mock(Event.class);
    when(repository.save(event)).thenReturn(event);

    service.create(event);

    verify(repository).save(event);
  }

  @Test
  void findByIdEmpty() {
    when(repository.findById(ID)).thenReturn(Optional.empty());

    var event = service.findBy(ID);

    verify(repository).findById(ID);
    Assertions.assertThat(event).isEmpty();
  }

  @Test
  void findById() {
    var eventMock = mock(Event.class);
    when(repository.findById(ID)).thenReturn(Optional.of(eventMock));

    var event = service.findBy(ID);

    verify(repository).findById(ID);
    Assertions.assertThat(event).hasValue(eventMock);
  }
}
