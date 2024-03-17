package com.marvel.superheros.superheros.service.impl;

import com.marvel.superheros.superheros.domain.entities.HeroDAO;
import com.marvel.superheros.superheros.service.SuperHerosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class SuperHerosServiceImpl implements SuperHerosService {

    @Override
    public Mono<HeroDAO> addHero(HeroDAO dao) {
        return null;
    }
}
