package com.marvel.superheros.superheros.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
public class HeroDTO {

    @NotEmpty(message = "The real name of the hero is required.")
    private String realName;
    @NotEmpty(message = "The power of the hero is required.")
    private String power;
    @NotEmpty(message = "The powerLevel of the hero is required.")
    private int powerLevel;
    @NotEmpty(message = "The nickname is required.")
    private String heroNickname;
    private String origin;

}
