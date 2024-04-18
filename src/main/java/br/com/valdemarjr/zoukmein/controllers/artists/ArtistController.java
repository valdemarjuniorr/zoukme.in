package br.com.valdemarjr.zoukmein.controllers.artists;

import br.com.valdemarjr.zoukmein.controllers.responses.ArtistResponse;
import br.com.valdemarjr.zoukmein.exceptions.ArtistNotFoundException;
import br.com.valdemarjr.zoukmein.services.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artists")
public class ArtistController {

  private final ArtistService service;

  @GetMapping("/{id}")
  ArtistResponse findById(@PathVariable Long id) {
    var response = service.findById(id).orElseThrow(ArtistNotFoundException::new);
    return new ArtistResponse(response);
  }

  @PostMapping
  void create(@RequestBody ArtistRequest request) {
    service.create(request.toEntity());
  }

  @DeleteMapping("/{id}")
  void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
