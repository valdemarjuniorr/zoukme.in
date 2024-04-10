package br.com.valdemarjr.zoukmein.repositories;

import br.com.valdemarjr.zoukmein.domain.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {}
