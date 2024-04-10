-- Organizer
INSERT INTO social_media (id, instagram)
VALUES (1, 'https://www.instagram.com/valdemarjuniorr');

INSERT INTO person (id, name, email, mobile, social_media_id)
VALUES (1, 'Valdemar Jr', 'valdemarjuniorr@gmail.com', '47988594002', 1);

INSERT INTO organizer(id, description)
VALUES (1, 'Criador do evento ZoukMe In');

-- DJ
INSERT INTO social_media (id, instagram)
VALUES (2, 'https://www.instagram.com/vjrfotografia');

INSERT INTO person (id, name, email, mobile, social_media_id)
VALUES (2, 'Valdz DJ', 'valdemarjuniorr@gmail.com', '47988594002', 2);

INSERT INTO artist (id, description)
VALUES (2, 'Professor de zouk e DJ');

-- Event
INSERT INTO social_media (id, instagram)
VALUES (3, 'https://www.instagram.com/zoukmein');

INSERT INTO address (id, street, number, city, state, zip_code)
VALUES (1, 'Rua 15 de Novembro', 123, 'Joinville', 'SC', '89218321');

INSERT INTO event (id, address_id, organizer_id, social_media_id, start_date, description, name, type)
VALUES (1, 1, 1, 3, '2024-06-30T09:00:00', 'Festa para os amantes do zouk em Joinville', 'ZoukMe In Joinville', 'PARTY');

INSERT INTO event_artists (event_id, artists_id)
VALUES (1, 2);
