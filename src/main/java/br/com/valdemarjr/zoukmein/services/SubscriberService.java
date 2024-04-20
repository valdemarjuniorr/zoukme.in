package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.Subscriber;
import br.com.valdemarjr.zoukmein.exceptions.SubscriberNotFoundException;
import br.com.valdemarjr.zoukmein.repositories.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriberService {

  private final SubscriberRepository repository;

  public void create(Subscriber subscriber) {
    repository.save(subscriber);
    // send email
  }

  public void activate(Long id) {
    var subscriber = repository.findById(id).orElseThrow(SubscriberNotFoundException::new);
    subscriber.setActive(true);
    repository.save(subscriber);
  }
}
