package br.com.valdemarjr.zoukmein.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Subscriber not found")
public class SubscriberNotFoundException extends RuntimeException {}
