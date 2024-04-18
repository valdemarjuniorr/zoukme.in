package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.persons.Organizer;
import br.com.valdemarjr.zoukmein.repositories.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizerService {

  private final OrganizerRepository repository;

  public void create(Organizer organizer) {
    organizer.getPhotos().forEach(photo -> photo.setPerson(organizer));
    repository.save(organizer);
  }

  public Optional<Organizer> findBy(Long id) {
    return repository.findById(id);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
