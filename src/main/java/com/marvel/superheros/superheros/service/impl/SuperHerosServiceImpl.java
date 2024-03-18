package com.marvel.superheros.superheros.service.impl;

import com.marvel.superheros.superheros.domain.entities.HeroDAO;
import com.marvel.superheros.superheros.repository.HerosRepository;
import com.marvel.superheros.superheros.service.SuperHerosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.marvel.superheros.superheros.util.Constants.ErrorCodeEnum.ERR_3011;
import static com.marvel.superheros.superheros.util.Utils.getErrorDTO;

@Service
@Slf4j
public class SuperHerosServiceImpl implements SuperHerosService {

    @Autowired
    private HerosRepository repository;

    @Override
    public Mono<Object> addHero(HeroDAO dao) {
        if(!getFullHeros().stream().map(HeroDAO::getHeroNickname).toList().contains(dao.getHeroNickname())) {
            return Mono.just(repository.save(dao));
        }else {
            return Mono.just(new ResponseEntity<>(getErrorDTO(HttpStatus.UNPROCESSABLE_ENTITY, ERR_3011.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY));
        }
    }

    @Override
    public List<HeroDAO> getAllHeros() {
        return getFullHeros();
    }

    @Override
    public Optional<HeroDAO> getHeroById(String id) {
        return repository.findById(Long.valueOf(id));
    }

    @Override
    public Mono<Object> updateHero(HeroDAO dao) {
        if(getFullHeros().stream().map(HeroDAO::getHeroNickname).toList().contains(dao.getHeroNickname())) {
            return Mono.just(repository.save(dao));
        }else {
            return Mono.just(new ResponseEntity<>(getErrorDTO(HttpStatus.UNPROCESSABLE_ENTITY, ERR_3011.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY));
        }
    }

    @Override
    public boolean deleteHeroById(long id) {
        boolean isDeleted = false;

        Optional<HeroDAO> heroToDelete = repository.findById(id);
        if (heroToDelete.isPresent()) {
            repository.delete(heroToDelete.get());
            isDeleted = true;
        }

        return isDeleted;
    }

    public List<HeroDAO> getFullHeros() {
        return new ArrayList<>(repository.findAll());
    }
}
