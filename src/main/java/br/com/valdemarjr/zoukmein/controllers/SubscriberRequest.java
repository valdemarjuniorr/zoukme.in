package br.com.valdemarjr.zoukmein.controllers;

import br.com.valdemarjr.zoukmein.domain.Subscriber;

record SubscriberRequest(String name, String email) {

  public Subscriber toEntity() {
    return Subscriber.builder().name(name).email(email).active(false).build();
  }
}
