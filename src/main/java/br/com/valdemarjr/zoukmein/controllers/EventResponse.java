package br.com.valdemarjr.zoukmein.controllers;

import br.com.valdemarjr.zoukmein.controllers.responses.ArtistResponse;
import br.com.valdemarjr.zoukmein.controllers.responses.OrganizerResponse;
import br.com.valdemarjr.zoukmein.controllers.responses.SocialMediaResponse;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.domain.events.EventType;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

@Getter
class EventResponse {

  private String name;
  private String description;
  private LocalDateTime startDate;
  private EventType type;
  private String address;
  private OrganizerResponse organizer;
  private SocialMediaResponse socialMedia;
  private List<ArtistResponse> artists;

  public EventResponse(Event event) {
    this.name = event.getName();
    this.description = event.getDescription();
    this.startDate = event.getStartDate();
    this.type = event.getType();
    this.organizer =
        new OrganizerResponse(
            event.getOrganizer().getName(), event.getOrganizer().getDescription());
    this.socialMedia =
        new SocialMediaResponse(
            event.getSocialMedia().getInstagram(),
            event.getSocialMedia().getFacebook(),
            event.getSocialMedia().getWebSite());
    this.address = event.getAddress().fullAddress();
    this.artists =
        !CollectionUtils.isEmpty(event.getArtists())
            ? event.getArtists().stream().map(ArtistResponse::new).toList()
            : List.of();
  }
}
