package br.com.valdemarjr.zoukmein.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.valdemarjr.zoukmein.domain.persons.Artist;
import br.com.valdemarjr.zoukmein.repositories.ArtistRepository;

import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

  private static final long ID = 1L;
  @InjectMocks private ArtistService service;

  @Mock private ArtistRepository repository;

  @Test
  void findByIdNotFound() {
    Mockito.when(repository.findById(ID)).thenReturn(Optional.empty());

    var artist = service.findById(ID);

    Assertions.assertThat(artist).isEmpty();

    verify(repository).findById(ID);
  }

  @Test
  void findById() {
    var mock = mock(Artist.class);
    Mockito.when(repository.findById(ID)).thenReturn(Optional.of(mock));

    var artist = service.findById(ID);

    Assertions.assertThat(artist).isPresent().contains(mock);
    verify(repository).findById(ID);
  }

  @Test
  void create() {
    var artist = mock(Artist.class);

    service.create(artist);

    verify(repository).save(artist);
  }

  @Test
  void delete() {
    service.delete(ID);

    verify(repository).deleteById(ID);
  }

  @Test
  void findAllByPageableEmpty() {
    var pageable = mock(Pageable.class);
    var page = mock(Page.class);
    when(page.getContent()).thenReturn(List.of());
    when(repository.findAll(pageable)).thenReturn(page);

    var artists = service.findAllBy(pageable);

    Assertions.assertThat(artists).isEmpty();
    verify(repository).findAll(pageable);
    verify(page).getContent();
  }

  @Test
  void findAllByPageable() {
    var artistMock = mock(Artist.class);
    var pageable = mock(Pageable.class);
    var page = mock(Page.class);
    when(page.getContent()).thenReturn(List.of(artistMock));
    when(repository.findAll(pageable)).thenReturn(page);

    var artists = service.findAllBy(pageable);

    Assertions.assertThat(artists).isNotEmpty().contains(artistMock);
    verify(repository).findAll(pageable);
    verify(page).getContent();
  }
}
