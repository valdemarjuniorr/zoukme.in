package br.com.valdemarjr.zoukmein.controllers.organizers;

import br.com.valdemarjr.zoukmein.exceptions.OrganizerNotFoundException;
import br.com.valdemarjr.zoukmein.services.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizers")
public class OrganizerController {

    private final OrganizerService service;

    @GetMapping("/{id}")
    OrganizerResponse findOrganizerBy(@PathVariable Long id) {
        return service.findBy(id)
                .map(OrganizerResponse::from)
                .orElseThrow(OrganizerNotFoundException::new);
    }

    @PostMapping
    void create(@RequestBody OrganizerRequest request) {
        service.create(request.toEntity());
    }

}
