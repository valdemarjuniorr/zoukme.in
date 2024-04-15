package br.com.valdemarjr.zoukmein.controllers.events;

import br.com.valdemarjr.zoukmein.controllers.requests.AddressRequest;
import br.com.valdemarjr.zoukmein.controllers.requests.SocialMediaRequest;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.domain.events.EventType;
import br.com.valdemarjr.zoukmein.domain.persons.Artist;
import br.com.valdemarjr.zoukmein.domain.persons.Organizer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EventRequest {
  private String name;
  private String description;
  private LocalDateTime startDate;
  private EventType type;
  private Long organizerId;
  private SocialMediaRequest socialMedia;
  private AddressRequest address;
  private List<Long> artistIds;

  public Event toEntity() {
    return Event.builder()
        .name(this.name)
        .description(this.description)
        .startDate(this.startDate)
        .type(this.type)
        .organizer(Organizer.builder().id(this.organizerId).build())
        .socialMedia(this.socialMedia.toEntity())
        .address(this.address.toEntity())
        .artists(getArtists())
        .build();
  }

  private List<Artist> getArtists() {
    return this.artistIds.stream().map(this::newArtist).toList();
  }

  private Artist newArtist(Long id) {
    return Artist.builder().id(id).build();
  }
}
