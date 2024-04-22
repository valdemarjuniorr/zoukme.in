package br.com.valdemarjr.zoukmein.controllers.participants;

import br.com.valdemarjr.zoukmein.controllers.responses.SocialMediaResponse;
import br.com.valdemarjr.zoukmein.domain.SocialMedia;
import br.com.valdemarjr.zoukmein.domain.assets.Photo;
import br.com.valdemarjr.zoukmein.domain.persons.Participant;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParticipantResponseTest {

  private static final String NAME = "Valdemar";
  private static final String EMAIL = "mail@mail.com";
  private static final String MOBILE = "999999999";
  private static final String PHOTO_URL = "http://photo.com";
  private static final String INSTAGRAM = "instagram";
  private static final String FACEBOOK = "facebook";
  private static final String URL = "http://website.com";

  @Test
  void of() {
    var participant =
        Participant.builder()
            .name(NAME)
            .email(EMAIL)
            .mobile(MOBILE)
            .photos(List.of(Photo.builder().url(PHOTO_URL).build()))
            .socialMedia(
                SocialMedia.builder().instagram(INSTAGRAM).facebook(FACEBOOK).webSite(URL).build())
            .build();

    var respponse = ParticipantResponse.of(participant);

    Assertions.assertThat(respponse.name()).isEqualTo(NAME);
    Assertions.assertThat(respponse.email()).isEqualTo(EMAIL);
    Assertions.assertThat(respponse.mobile()).isEqualTo(MOBILE);
    Assertions.assertThat(respponse.photoUrl()).isEqualTo(PHOTO_URL);
    Assertions.assertThat(respponse.socialMedia())
        .isEqualTo(new SocialMediaResponse(INSTAGRAM, FACEBOOK, URL));
  }
}
