package com.marvel.superheros.superheros.api.controller;

import com.marvel.superheros.superheros.api.domain.dto.HeroDTO;
import com.marvel.superheros.superheros.api.exception.ResponseException;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("heros")
@Api(value = "Marvel Heros microservice management")
public interface HerosManagementControllerIntr {

    @PostMapping(value = "add-hero", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity> addNewHero (@RequestBody HeroDTO dto) throws ResponseException;
}

