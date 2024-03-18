package com.marvel.superheros.superheros.api.controller.impl;

import com.marvel.superheros.superheros.api.controller.HeroesManagementController;
import com.marvel.superheros.superheros.domain.dto.HeroDTO;
import com.marvel.superheros.superheros.api.exception.ResponseException;
import com.marvel.superheros.superheros.mapper.HeroEntityMapper;
import com.marvel.superheros.superheros.service.SuperHerosService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("heros")
@Api(value = "Super Heros microservice management")
@CrossOrigin(origins = { "http://localhost:3000" })
public class HerosManagementControllerImpl implements HeroesManagementController {

    @Autowired
    private SuperHerosService superHerosSvc;

    private HeroEntityMapper mapper;

    @Override
    public Mono<ResponseEntity<Object>> addNewHero(HeroDTO dto) throws ResponseException {
        return superHerosSvc.addHero(mapper.heroDTOtoDAO(dto))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Object>> modifyHero(HeroDTO dto) throws ResponseException {
        return superHerosSvc.updateHero(mapper.heroDTOtoDAO(dto))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<HttpStatus>> disableHero(long id) throws ResponseException {
        try {
            if (superHerosSvc.deleteHeroById(id)) {
                return Mono.just(new ResponseEntity<>(HttpStatus.NO_CONTENT));
            }else{
                return Mono.just(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
            }
        } catch (Exception ex) {
            return Mono.just(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public Mono<ResponseEntity<List<HeroDTO>>> getAllHeros() throws ResponseException {
        return Mono.just(new ResponseEntity<>(superHerosSvc.getAllHeros()
                .stream()
                .map(hero -> mapper.heroDAOtoDTO(hero))
                .collect(Collectors.toList()),
                HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<HeroDTO>> getHeroById(String id) throws ResponseException {
        Optional<HeroDTO> hero = Optional.ofNullable(mapper.heroDAOtoDTO(superHerosSvc.getHeroById(id).orElse(null)));
        return hero
                .map(heroDTO -> Mono.just(new ResponseEntity<>(heroDTO, HttpStatus.OK)))
                .orElseGet(() -> Mono.just(new ResponseEntity<>(null, HttpStatus.NOT_FOUND)));
    }
}
