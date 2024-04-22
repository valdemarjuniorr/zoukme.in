package br.com.valdemarjr.zoukmein.controllers.participants;

import br.com.valdemarjr.zoukmein.exceptions.ParticipantNotFoundException;
import br.com.valdemarjr.zoukmein.services.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participants")
public class ParticipantController {

  private final ParticipantService service;

  @PostMapping
  void create(@RequestBody ParticipantRequest request) {
    service.create(request.toEntity());
  }

  @GetMapping("/{id}")
  ParticipantResponse findBy(@PathVariable Long id) {
    var participant = service.findBy(id).orElseThrow(ParticipantNotFoundException::new);
    return ParticipantResponse.of(participant);
  }
}
