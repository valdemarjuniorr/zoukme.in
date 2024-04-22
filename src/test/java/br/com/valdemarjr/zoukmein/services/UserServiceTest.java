package br.com.valdemarjr.zoukmein.services;

import static org.junit.jupiter.api.Assertions.*;

import br.com.valdemarjr.zoukmein.domain.persons.User;
import br.com.valdemarjr.zoukmein.repositories.UserRepository;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  private static final long ID = 1L;
  @InjectMocks private UserService service;

  @Mock private UserRepository repository;

  @Test
  void create() {
    var user = Mockito.mock(User.class);
    Mockito.when(repository.save(user)).thenReturn(user);

    service.create(user);

    Mockito.verify(repository).save(user);
  }

  @Test
  void findBy() {
    var user = Mockito.mock(User.class);
    Mockito.when(repository.findById(ID)).thenReturn(Optional.of(user));

    var result = service.findBy(ID);

    Assertions.assertThat(result).contains(user);
    Mockito.verify(repository).findById(ID);
  }

  @Test
  void findByNotFound() {
    Mockito.when(repository.findById(ID)).thenReturn(Optional.empty());

    var result = service.findBy(ID);

    Assertions.assertThat(result).isEmpty();
    Mockito.verify(repository).findById(ID);
  }
}
