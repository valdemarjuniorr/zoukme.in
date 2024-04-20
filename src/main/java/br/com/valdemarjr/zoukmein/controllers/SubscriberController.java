package br.com.valdemarjr.zoukmein.controllers;

import br.com.valdemarjr.zoukmein.services.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscribers")
public class SubscriberController {

  private final SubscriberService subscriberService;

  @PostMapping
  void create(@RequestBody SubscriberRequest request) {
    subscriberService.create(request.toEntity());
  }

  @GetMapping("/{id}/activate")
  void activate(@PathVariable Long id) {
    subscriberService.activate(id);
  }
}
