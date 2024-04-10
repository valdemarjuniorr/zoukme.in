package br.com.valdemarjr.zoukmein.controllers;

import br.com.valdemarjr.zoukmein.domain.SocialMedia;
import br.com.valdemarjr.zoukmein.domain.events.Event;
import br.com.valdemarjr.zoukmein.domain.events.EventType;
import br.com.valdemarjr.zoukmein.domain.persons.Artist;
import br.com.valdemarjr.zoukmein.domain.persons.Organizer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    this.organizer = new OrganizerResponse(event.getOrganizer());
    this.socialMedia = new SocialMediaResponse(event.getSocialMedia());
    this.address = event.getAddress().fullAddress();
    this.artists =
        !CollectionUtils.isEmpty(event.getArtists())
            ? event.getArtists().stream().map(ArtistResponse::new).toList()
            : List.of();
  }

  @Getter
  static class OrganizerResponse {

    private String name;
    private String description;

    public OrganizerResponse(Organizer organizer) {
      this.name = organizer.getName();
      this.description = organizer.getDescription();
    }
  }

  @Getter
  static class SocialMediaResponse {
    private String instagram;
    private String facebook;
    private String twitter;

    public SocialMediaResponse(SocialMedia socialMedia) {
      if (Objects.nonNull(socialMedia)) {
        this.instagram = socialMedia.getInstagram();
        this.facebook = socialMedia.getFacebook();
        this.twitter = socialMedia.getWebSite();
      }
    }
  }

  @Getter
  static class ArtistResponse {

    private String name;
    private String photoUrl;

    ArtistResponse(Artist artist) {
      if (Objects.nonNull(artist)) {
        this.name = artist.getName();
        this.photoUrl =
            !CollectionUtils.isEmpty(artist.getPhotos())
                ? artist.getPhotos().getFirst().getUrl()
                : "";
      }
    }
  }
}
