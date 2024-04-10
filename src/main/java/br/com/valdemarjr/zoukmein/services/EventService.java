package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

  private final EventRepository repository;

  public Event create(Event event) {
    return repository.save(event);
  }

  public Optional<Event> findBy(Long id) {
    return repository.findById(id);
  }
}
