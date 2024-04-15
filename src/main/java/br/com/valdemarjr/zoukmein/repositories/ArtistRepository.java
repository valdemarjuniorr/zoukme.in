package br.com.valdemarjr.zoukmein.repositories;


import br.com.valdemarjr.zoukmein.domain.persons.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {}
