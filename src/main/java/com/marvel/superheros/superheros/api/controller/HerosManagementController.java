package com.marvel.superheros.superheros.api.controller;

import com.marvel.superheros.superheros.api.domain.dto.HeroDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("heros")
@Api(value = "Marvel Heros microservice management")
public class HerosManagementController implements HerosManagementControllerIntr{

    @PostMapping(value = "add-hero")
    public Mono<ResponseEntity> addNewHero(@RequestBody HeroDTO dto) {
        return null;
    }
}
