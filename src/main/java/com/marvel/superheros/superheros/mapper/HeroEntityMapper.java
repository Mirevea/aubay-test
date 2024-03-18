package com.marvel.superheros.superheros.mapper;

import com.marvel.superheros.superheros.domain.dto.HeroDTO;
import com.marvel.superheros.superheros.domain.entities.HeroDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeroEntityMapper {
    HeroDAO heroDTOtoDAO(HeroDTO source);
    HeroDTO heroDAOtoDTO(HeroDAO source);
}
