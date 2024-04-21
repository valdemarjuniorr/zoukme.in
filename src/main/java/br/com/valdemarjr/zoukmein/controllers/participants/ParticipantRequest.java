package br.com.valdemarjr.zoukmein.controllers.participants;

import br.com.valdemarjr.zoukmein.domain.events.Decision;

public record ParticipantRequest(Decision decision) {}
