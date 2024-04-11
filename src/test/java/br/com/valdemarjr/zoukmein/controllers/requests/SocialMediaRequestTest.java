package br.com.valdemarjr.zoukmein.controllers.requests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SocialMediaRequestTest {

  private static final String INSTAGRAM = "instagram";
  private static final String FACEBOOK = "facebook";
  private static final String WEB_SITE = "webSite";

  @Test
  void toEntity() {
    var entity = new SocialMediaRequest(INSTAGRAM, FACEBOOK, WEB_SITE).toEntity();
    Assertions.assertThat(entity.getInstagram()).isEqualTo(INSTAGRAM);
    Assertions.assertThat(entity.getFacebook()).isEqualTo(FACEBOOK);
    Assertions.assertThat(entity.getWebSite()).isEqualTo(WEB_SITE);
  }
}
