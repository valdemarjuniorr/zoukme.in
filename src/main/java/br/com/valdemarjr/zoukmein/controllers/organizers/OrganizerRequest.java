package br.com.valdemarjr.zoukmein.controllers.organizers;

import br.com.valdemarjr.zoukmein.controllers.requests.SocialMediaRequest;
import br.com.valdemarjr.zoukmein.domain.assets.Photo;
import br.com.valdemarjr.zoukmein.domain.persons.Organizer;
import java.util.List;

record OrganizerRequest(
    String name,
    String description,
    String email,
    String mobile,
    String photoUrl,
    SocialMediaRequest socialMedia) {

  public Organizer toEntity() {
    return Organizer.builder()
        .name(name)
        .description(description)
        .email(email)
        .mobile(mobile)
        .photos(List.of(Photo.builder().url(photoUrl).build()))
        .socialMedia(socialMedia.toEntity())
        .build();
  }
}
