package com.marvel.superheros.superheros.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@Builder
public class HeroDAO {

    @Id
    private String id;
    private String realName;
    private String power;
    private int powerLevel;
    private String heroNickname;
    private String origin;

}
