package com.marvel.superheros.superheros.service;

import com.marvel.superheros.superheros.domain.entities.HeroDAO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface SuperHerosService {

    Mono<HeroDAO> addHero(HeroDAO dao);
    
}
