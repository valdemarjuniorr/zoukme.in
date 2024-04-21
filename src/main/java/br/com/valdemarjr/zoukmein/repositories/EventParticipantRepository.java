package br.com.valdemarjr.zoukmein.repositories;

import br.com.valdemarjr.zoukmein.domain.events.EventParticipant;
import org.springframework.data.repository.CrudRepository;

public interface EventParticipantRepository extends CrudRepository<EventParticipant, Long> {}
