package br.com.valdemarjr.zoukmein.controllers.participants;

import br.com.valdemarjr.zoukmein.controllers.requests.SocialMediaRequest;
import br.com.valdemarjr.zoukmein.domain.assets.Photo;
import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import java.util.List;

record ParticipantRequest(
    String name, String email, String mobile, String photoUrl, SocialMediaRequest socialMedia) {

  public Participant toEntity() {
    return Participant.builder()
        .name(name)
        .email(email)
        .mobile(mobile)
        .photos(List.of(Photo.builder().url(photoUrl).build()))
        .socialMedia(socialMedia.toEntity())
        .build();
  }
}
