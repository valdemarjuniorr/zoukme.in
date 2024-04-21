package br.com.valdemarjr.zoukmein.repositories;

import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {}
