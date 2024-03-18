package com.marvel.superheros.superheros.service;

import com.marvel.superheros.superheros.domain.entities.HeroDAO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public interface SuperHerosService {

    Mono<Object> addHero(HeroDAO dao);

    List<HeroDAO> getAllHeros();

    Optional<HeroDAO> getHeroById(String id);

    Mono<Object> updateHero(HeroDAO heroDTOtoDAO);

    boolean deleteHeroById(long id);

    List<HeroDAO> getHeroByFilter(String seq);
}
