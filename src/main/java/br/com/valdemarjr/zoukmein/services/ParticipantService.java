package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import br.com.valdemarjr.zoukmein.repositories.ParticipantRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantService {

  private final ParticipantRepository repository;

  public Optional<Participant> findBy(Long id) {
    return repository.findById(id);
  }
}
