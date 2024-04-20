package br.com.valdemarjr.zoukmein.services;

import static org.mockito.Mockito.when;

import br.com.valdemarjr.zoukmein.domain.Subscriber;
import br.com.valdemarjr.zoukmein.exceptions.SubscriberNotFoundException;
import br.com.valdemarjr.zoukmein.repositories.SubscriberRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SubscriberServiceTest {

  private static final long ID = 1L;

  @InjectMocks private SubscriberService subscriberService;

  @Mock private SubscriberRepository subscriberRepository;

  @Test
  void create() {
    var mock = Mockito.mock(Subscriber.class);
    when(subscriberRepository.save(mock)).thenReturn(mock);

    subscriberService.create(mock);

    Mockito.verify(subscriberRepository).save(mock);
  }
  
  @Test
  void activate() {
    var mock = Mockito.mock(Subscriber.class);
    when(subscriberRepository.findById(ID)).thenReturn(Optional.of(mock));

    subscriberService.activate(ID);

    Mockito.verify(subscriberRepository).findById(ID);
    Mockito.verify(subscriberRepository).save(mock);
  }

  @Test
  void activateException() {
    when(subscriberRepository.findById(ID)).thenReturn(Optional.empty());

    Assertions.assertThrows(SubscriberNotFoundException.class, () -> subscriberService.activate(ID));

    Mockito.verify(subscriberRepository).findById(ID);
  }
}
