package br.com.valdemarjr.zoukmein.controllers.participants;

import br.com.valdemarjr.zoukmein.controllers.requests.SocialMediaRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParticipantRequestTest {

  private static final String NAME = "name";
  private static final String EMAIL = "email";
  private static final String MOBILE = "mobile";
  private static final String PHOTO_URL = "photoUrl";
  private static final String INSTAGRAM = "instagram";
  private static final String FACEBOOK = "facebook";
  private static final String WEB_SITE = "webSite";

  @Test
  void toEntity() {
    var request =
        new ParticipantRequest(
            NAME, EMAIL, MOBILE, PHOTO_URL, new SocialMediaRequest(INSTAGRAM, FACEBOOK, WEB_SITE));

    var entity = request.toEntity();

    Assertions.assertThat(entity.getName()).isEqualTo(NAME);
    Assertions.assertThat(entity.getEmail()).isEqualTo(EMAIL);
    Assertions.assertThat(entity.getMobile()).isEqualTo(MOBILE);
    Assertions.assertThat(entity.getPhotos()).hasSize(1);
    Assertions.assertThat(entity.getPhotos().get(0).getUrl()).isEqualTo(PHOTO_URL);
    Assertions.assertThat(entity.getSocialMedia().getInstagram()).isEqualTo(INSTAGRAM);
    Assertions.assertThat(entity.getSocialMedia().getFacebook()).isEqualTo(FACEBOOK);
    Assertions.assertThat(entity.getSocialMedia().getWebSite()).isEqualTo(WEB_SITE);
  }
}
