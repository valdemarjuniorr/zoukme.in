package br.com.valdemarjr.zoukmein.controllers.organizers;

import br.com.valdemarjr.zoukmein.controllers.responses.SocialMediaResponse;
import br.com.valdemarjr.zoukmein.domain.persons.Organizer;

record OrganizerResponse(
    String name,
    String description,
    String email,
    String mobile,
    String photoUrl,
    SocialMediaResponse socialMedia) {

  public static OrganizerResponse from(Organizer organizer) {
    return new OrganizerResponse(
        organizer.getName(),
        organizer.getDescription(),
        organizer.getEmail(),
        organizer.getMobile(),
        organizer.firstPhoto(),
        new SocialMediaResponse(
            organizer.getSocialMedia().getInstagram(),
            organizer.getSocialMedia().getFacebook(),
            organizer.getSocialMedia().getWebSite()));
  }
}
