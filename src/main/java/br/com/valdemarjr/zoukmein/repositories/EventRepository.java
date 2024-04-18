package br.com.valdemarjr.zoukmein.repositories;

import br.com.valdemarjr.zoukmein.domain.address.State;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByAddressState(State state, Pageable pageable);
}
