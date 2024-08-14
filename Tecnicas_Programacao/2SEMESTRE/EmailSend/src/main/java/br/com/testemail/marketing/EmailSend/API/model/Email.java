package br.com.testemail.marketing.EmailSend.API.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Email(
  @JsonProperty("name") String name,
  @JsonProperty("email") String email
) {}
