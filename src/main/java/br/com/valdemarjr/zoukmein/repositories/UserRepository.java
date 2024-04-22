package br.com.valdemarjr.zoukmein.repositories;

import br.com.valdemarjr.zoukmein.domain.persons.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
