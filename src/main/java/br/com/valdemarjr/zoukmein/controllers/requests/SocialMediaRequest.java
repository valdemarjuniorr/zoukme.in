package br.com.valdemarjr.zoukmein.controllers.requests;

import br.com.valdemarjr.zoukmein.domain.SocialMedia;

public record SocialMediaRequest(String instagram, String facebook, String webSite) {

  public SocialMedia toEntity() {
    return SocialMedia.builder()
        .instagram(this.instagram)
        .facebook(this.facebook)
        .webSite(this.webSite)
        .build();
  }
}
