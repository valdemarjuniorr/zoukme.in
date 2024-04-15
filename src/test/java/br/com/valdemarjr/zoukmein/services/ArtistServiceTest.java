package br.com.valdemarjr.zoukmein.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import br.com.valdemarjr.zoukmein.repositories.ArtistRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

    private static final long ID = 1L;
    @InjectMocks
    private ArtistService service;

    @Mock
    private ArtistRepository repository;

  @Test
  void findByIdNotFound() {
      Mockito.when(repository.findById(ID)).thenReturn(Optional.empty());

      var artist = service.findById(ID);

      Assertions.assertThat(artist).isEmpty();

      verify(repository).findById(ID);
  }
}
