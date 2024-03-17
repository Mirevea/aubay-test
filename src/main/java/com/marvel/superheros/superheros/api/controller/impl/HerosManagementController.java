package com.marvel.superheros.superheros.api.controller.impl;

import com.marvel.superheros.superheros.api.controller.HeroesManagementControllerIntr;
import com.marvel.superheros.superheros.domain.dto.HeroDTO;
import com.marvel.superheros.superheros.api.exception.ResponseException;
import com.marvel.superheros.superheros.service.SuperHerosService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("heros")
@Api(value = "Super Heros microservice management")
public class HerosManagementController implements HeroesManagementControllerIntr {

    @Autowired
    private SuperHerosService superHerosSvc;

    @Override
    public Mono<ResponseEntity<HeroDTO>> addNewHero(HeroDTO dto) throws ResponseException {
        return superHerosSvc.;
    }

    @Override
    public Mono<ResponseEntity> modifyHero(HeroDTO dto) throws ResponseException {
        return null;
    }

    @Override
    public Mono<ResponseEntity> disableHero(String id, String name) throws ResponseException {
        return null;
    }

    @Override
    public Mono<ResponseEntity<List<HeroDTO>>> getAllHeros() throws ResponseException {
        return null;
    }

    @Override
    public Mono<ResponseEntity<HeroDTO>> getHeroById(String id) throws ResponseException {
        return null;
    }
}
