package br.com.valdemarjr.zoukmein.controllers.participants;

import br.com.valdemarjr.zoukmein.controllers.responses.SocialMediaResponse;
import br.com.valdemarjr.zoukmein.domain.persons.Participant;

record ParticipantResponse(
    String name, String email, String mobile, String photoUrl, SocialMediaResponse socialMedia) {

  public static ParticipantResponse of(Participant participant) {
    return new ParticipantResponse(
        participant.getName(),
        participant.getEmail(),
        participant.getMobile(),
        participant.firstPhoto(),
        new SocialMediaResponse(
            participant.getSocialMedia().getInstagram(),
            participant.getSocialMedia().getFacebook(),
            participant.getSocialMedia().getWebSite()));
  }
}
