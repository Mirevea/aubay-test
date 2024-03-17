package com.marvel.superheros.superheros.api.controller;

import com.marvel.superheros.superheros.domain.dto.HeroDTO;
import com.marvel.superheros.superheros.api.exception.ResponseException;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("heros")
@Api(value = "Marvel Heroes microservice management")
public interface HeroesManagementControllerIntr {

    @PostMapping(value = "addHero", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<HeroDTO>> addNewHero (@RequestBody HeroDTO dto) throws ResponseException;

    @PutMapping(value = "modifyHero", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity> modifyHero (@RequestBody HeroDTO dto) throws ResponseException;

    @DeleteMapping(value = "disableHero", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity> disableHero (@PathVariable (required = false) String id, @PathVariable (required = false) String name) throws ResponseException;

    @GetMapping(value = "listHeroes", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<List<HeroDTO>>> getAllHeros () throws ResponseException;

    @GetMapping(value = "getHero", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<HeroDTO>> getHeroById (@PathVariable String id) throws ResponseException;
}

