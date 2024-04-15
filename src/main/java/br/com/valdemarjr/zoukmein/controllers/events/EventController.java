package br.com.valdemarjr.zoukmein.controllers.events;

import br.com.valdemarjr.zoukmein.exceptions.EventNotFoundException;
import br.com.valdemarjr.zoukmein.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

  private final EventService service;

  @PostMapping
  void create(@RequestBody EventRequest request) {
    service.create(request.toEntity());
  }

  @GetMapping("/{id}")
  EventResponse findById(@PathVariable Long id) {
    var eventOp = service.findBy(id);
    return eventOp.map(EventResponse::new).orElseThrow(EventNotFoundException::new);
  }
}
