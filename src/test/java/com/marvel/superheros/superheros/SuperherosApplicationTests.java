package com.marvel.superheros.superheros;

import com.marvel.superheros.superheros.domain.entities.HeroDAO;
import com.marvel.superheros.superheros.repository.HerosRepository;
import com.marvel.superheros.superheros.service.impl.SuperHerosServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class SuperHerosServiceImplTest {
    private final String username = "b36dbc74-1498-49bd-adec-0b53c2b268f8";

    @Autowired
    private ApplicationContext context;

    @InjectMocks
    private SuperHerosServiceImpl superHerosService;

    @Mock
    private HerosRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void contextLoads() {
        assertNotNull(this.context);
    }

    @Test
    void testAddHero_Success() {
        // Test addHero method with success scenario
        HeroDAO heroDAO = new HeroDAO();
        heroDAO.setHeroNickname("Superman");

        when(repository.save(heroDAO)).thenReturn(heroDAO);

        Mono<Object> result = superHerosService.addHero(heroDAO);

        assertNotNull(result);
        assertEquals(heroDAO, result.block());
    }

    @Test
    void testAddHero_DuplicateHero() {
        // Test addHero method with duplicate hero scenario
        HeroDAO heroDAO = new HeroDAO();
        heroDAO.setHeroNickname("Batman");

        when(repository.findAll()).thenReturn(new ArrayList<>());
        when(repository.save(heroDAO)).thenReturn(heroDAO);

        superHerosService.addHero(heroDAO);

        when(repository.findAll()).thenReturn(List.of(heroDAO));

        Mono<Object> result = superHerosService.addHero(heroDAO);

        assertNotNull(result);
        assertTrue(result.block() instanceof ResponseEntity);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, ((ResponseEntity<?>) Objects.requireNonNull(result.block())).getStatusCode());
    }

    @Test
    void testGetAllHeros() {
        // Test getAllHeros method
        List<HeroDAO> heroList = new ArrayList<>();
        heroList.add(new HeroDAO(1L, "Tony Stark", "Armadura superfuerza regenerativa", 100, "Iron Man", "Tierra"));
        heroList.add(new HeroDAO(2L, "Wanda Maximoff", "Mutante magia del caos control mental", 150, "Bruja Escarlata", "Tierra"));

        when(repository.findAll()).thenReturn(heroList);

        List<HeroDAO> result = superHerosService.getAllHeros();

        assertNotNull(result);
        assertEquals(heroList.size(), result.size());
    }

    @Test
    void testGetHeroById() {
        // Test getHeroById method
        HeroDAO heroDAO = new HeroDAO(4L, "Peter Parker", "Poderes aracnidos origen araña", 90, "Spider Man", "Tierra");
        Optional<HeroDAO> optionalHero = Optional.of(heroDAO);

        when(repository.findById(Long.valueOf("4"))).thenReturn(optionalHero);

        Optional<HeroDAO> result = superHerosService.getHeroById("4");

        assertTrue(result.isPresent());
        assertEquals(heroDAO, result.get());
    }

    @Test
    void testUpdateHero_Success() {
        // Test updateHero method with success scenario
        HeroDAO heroDAO = new HeroDAO(5L, "Bruce Banner", "Monstruo radioactivo", 166, "Hulk", "Tierra");

        when(repository.findAll()).thenReturn(new ArrayList<>());
        when(repository.save(heroDAO)).thenReturn(heroDAO);

        Mono<Object> result = superHerosService.updateHero(heroDAO);

        assertNotNull(result);
        assertEquals(heroDAO, result.block());
    }

    @Test
    void testUpdateHero_NotFound() {
        // Test updateHero method when hero is not found
        HeroDAO heroDAO = new HeroDAO(6L, "Stephen Vincent Strange", "Magia del multiverso", 142, "Dr Strange", "Tierra");

        when(repository.findAll()).thenReturn(new ArrayList<>());

        Mono<Object> result = superHerosService.updateHero(heroDAO);

        assertNotNull(result);
        assertTrue(result.block() instanceof ResponseEntity);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, ((ResponseEntity<?>) Objects.requireNonNull(result.block())).getStatusCode());
    }

    @Test
    void testDeleteHeroById_Success() {
        // Test deleteHeroById method with success scenario
        HeroDAO heroDAO = new HeroDAO(8L, "Gamora", "Asesina", 70, "Gamora", "Zen-Whoberi");

        when(repository.findById(Long.valueOf("8"))).thenReturn(Optional.of(heroDAO));

        boolean result = superHerosService.deleteHeroById(8L);

        assertTrue(result);
        verify(repository, times(1)).delete(heroDAO);
    }

    @Test
    void testDeleteHeroById_NotFound() {
        // Test deleteHeroById method when hero is not found
        when(repository.findById(Long.valueOf("1"))).thenReturn(Optional.empty());

        boolean result = superHerosService.deleteHeroById(1L);

        assertFalse(result);
        verify(repository, never()).delete(any());
    }

    @Test
    void testGetHeroByFilter() {
        // Test getHeroByFilter method
        List<HeroDAO> heroList = new ArrayList<>();
        heroList.add(new HeroDAO(1L, "Gamora", "Asesina", 70, "Gamora", "Zen-Whoberi"));
        heroList.add(new HeroDAO(2L, "Peter Parker", "Poderes aracnidos origen araña", 90, "Spider Man", "Tierra"));
        heroList.add(new HeroDAO(2L, "Clark Kent", "Super poderes de Krypton", 200, "Super Man", "Krypton"));

        when(repository.findAll()).thenReturn(heroList);

        List<HeroDAO> result = superHerosService.getHeroByFilter("man");

        assertNotNull(result);
        assertEquals(3, result.size());
    }
}

