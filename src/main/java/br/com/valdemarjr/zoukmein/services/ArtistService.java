package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.persons.Artist;
import br.com.valdemarjr.zoukmein.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistService {

  private final ArtistRepository repository;

  public Optional<Artist> findById(Long id) {
    return repository.findById(id);
  }

  public void create(Artist artist) {
    repository.save(artist);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  public List<Artist> findAllBy(Pageable pageable) {
    return repository.findAll(pageable).getContent();
  }
}
