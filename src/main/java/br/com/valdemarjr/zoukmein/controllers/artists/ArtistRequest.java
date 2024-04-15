package br.com.valdemarjr.zoukmein.controllers.artists;

import br.com.valdemarjr.zoukmein.controllers.requests.SocialMediaRequest;
import br.com.valdemarjr.zoukmein.domain.assets.Photo;
import br.com.valdemarjr.zoukmein.domain.persons.Artist;

import java.util.List;

record ArtistRequest(
    String name,
    String email,
    String mobile,
    SocialMediaRequest socialMedia,
    String photoUrl,
    String description) {
  public Artist toEntity() {
    return Artist.builder()
        .name(this.name)
        .description(this.description)
        .email(this.email)
        .mobile(this.mobile)
        .socialMedia(this.socialMedia.toEntity())
        .photos(List.of(Photo.builder().url(photoUrl).build()))
        .build();
  }
}
