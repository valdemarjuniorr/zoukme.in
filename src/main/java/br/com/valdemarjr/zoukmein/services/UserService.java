package br.com.valdemarjr.zoukmein.services;

import br.com.valdemarjr.zoukmein.domain.persons.User;
import br.com.valdemarjr.zoukmein.repositories.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public void create(User user) {
    repository.save(user);
  }

  public Optional<User> findBy(Long id) {
    return repository.findById(id);
  }
}
