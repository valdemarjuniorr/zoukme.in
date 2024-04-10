package br.com.valdemarjr.zoukmein.controllers;

import br.com.valdemarjr.zoukmein.exceptions.EventNotFoundException;
import br.com.valdemarjr.zoukmein.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

  private final EventService service;

  @GetMapping("/{id}")
  EventResponse findById(@PathVariable Long id) {
    var eventOp = service.findBy(id);
    return eventOp.map(EventResponse::new).orElseThrow(EventNotFoundException::new);
  }
}
