package br.com.valdemarjr.zoukmein.controllers.events;

import br.com.valdemarjr.zoukmein.domain.SocialMedia;
import br.com.valdemarjr.zoukmein.domain.address.Address;
import br.com.valdemarjr.zoukmein.domain.address.State;
import br.com.valdemarjr.zoukmein.domain.assets.Photo;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.domain.events.EventType;
import br.com.valdemarjr.zoukmein.domain.persons.Artist;
import br.com.valdemarjr.zoukmein.domain.persons.Organizer;
import java.time.LocalDateTime;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EventResponseTest {

  @Test
  void constructorOk() {
    var event =
        Event.builder()
            .name("Event")
            .description("Description")
            .startDate(LocalDateTime.now())
            .type(EventType.CONGRESS)
            .socialMedia(getSocialMedia())
            .organizer(
                Organizer.builder()
                    .description("Organizer Description")
                    .email("email@email.com")
                    .mobile("999999999")
                    .name("Organizer Name")
                    .socialMedia(getSocialMedia())
                    .photos(getPhotoWith("Organizer photoUrl", "Organizer description"))
                    .build())
            .address(
                Address.builder()
                    .city("City")
                    .state(State.SC)
                    .street("Street")
                    .zipCode("ZipCode")
                    .build())
            .artists(
                List.of(
                    Artist.builder()
                        .name("Artist name")
                        .photos(getPhotoWith("Artist photoUrl", "Artist description"))
                        .build()))
            .build();

    var response = new EventResponse(event);

    Assertions.assertThat(response.getName()).isEqualTo(event.getName());
    Assertions.assertThat(response.getDescription()).isEqualTo(event.getDescription());
    Assertions.assertThat(response.getStartDate()).isEqualTo(event.getStartDate());
    Assertions.assertThat(response.getType()).isEqualTo(event.getType());

    var organizer = response.getOrganizer();
    Assertions.assertThat(organizer.name()).isEqualTo(event.getOrganizer().getName());
    Assertions.assertThat(organizer.description()).isEqualTo(event.getOrganizer().getDescription());

    var socialMedia = response.getSocialMedia();
    Assertions.assertThat(socialMedia.facebook()).isEqualTo(event.getSocialMedia().getFacebook());
    Assertions.assertThat(socialMedia.instagram()).isEqualTo(event.getSocialMedia().getInstagram());
    Assertions.assertThat(socialMedia.webSite()).isEqualTo(event.getSocialMedia().getWebSite());

    Assertions.assertThat(response.getAddress()).isEqualTo(event.getAddress().fullAddress());
    Assertions.assertThat(response.getArtists()).hasSize(1);
  }

  private SocialMedia getSocialMedia() {
    return SocialMedia.builder()
        .facebook("facebook")
        .instagram("instagram")
        .webSite("webSite")
        .build();
  }

  private List<Photo> getPhotoWith(String url, String description) {
    return List.of(Photo.builder().url(url).description(description).build());
  }
}
