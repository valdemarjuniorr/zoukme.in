package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.address.State;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

  private final EventRepository repository;

  public void create(Event event) {
    repository.save(event);
  }

  public Optional<Event> findBy(Long id) {
    return repository.findById(id);
  }

  public List<Event> findByState(State state, Pageable pageable) {
    return repository.findByAddressStateOrderByStartDateAsc(state, pageable);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
