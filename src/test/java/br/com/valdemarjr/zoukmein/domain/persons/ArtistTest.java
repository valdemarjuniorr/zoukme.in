package br.com.valdemarjr.zoukmein.domain.persons;

import br.com.valdemarjr.zoukmein.domain.assets.Photo;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArtistTest {

  private static final String PHOTO_URL = "http://localhost:8080/photo.jpg";

  @Test
  void firstPhotoEmpty() {
    Assertions.assertThat(new Artist().firstPhoto()).isEmpty();
  }

  @Test
  void firstPhotoNotEmpty() {
    var photo = new Photo();
    photo.setUrl(PHOTO_URL);
    var artist = Artist.builder().photos(List.of(photo)).build();

    Assertions.assertThat(artist.firstPhoto()).isEqualTo(PHOTO_URL);
  }
}
