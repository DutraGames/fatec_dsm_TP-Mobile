package br.com.testemail.marketing.EmailSend.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Comment(
  @JsonProperty("postId") int postId,
  @JsonProperty("id") int id,
  @JsonProperty("name") String name,
  @JsonProperty("email") String email,
  @JsonProperty("body") String body
) {}
