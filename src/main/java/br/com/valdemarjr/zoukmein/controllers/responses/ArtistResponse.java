package br.com.valdemarjr.zoukmein.controllers.responses;

import br.com.valdemarjr.zoukmein.domain.persons.Artist;

public record ArtistResponse(String name, String photoUrl) {

  public ArtistResponse(Artist artist) {
    this(artist.getName(), artist.firstPhoto());
  }
}
