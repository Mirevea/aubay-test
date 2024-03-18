package com.marvel.superheros.superheros.domain.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
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
