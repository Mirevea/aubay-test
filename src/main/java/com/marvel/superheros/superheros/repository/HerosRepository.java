package com.marvel.superheros.superheros.repository;

import com.marvel.superheros.superheros.domain.entities.HeroDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HerosRepository extends JpaRepository<HeroDAO, Long> {
}
