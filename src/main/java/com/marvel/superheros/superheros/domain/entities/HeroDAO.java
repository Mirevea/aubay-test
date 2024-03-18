package com.marvel.superheros.superheros.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class HeroDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String realName;
    @Column(nullable = false)
    private String power;
    @Column(nullable = false)
    private int powerLevel;
    @Column(nullable = false)
    private String heroNickname;
    @Column(nullable = false)
    private String origin;

}
