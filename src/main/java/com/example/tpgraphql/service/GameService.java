package com.example.tpgraphql.service;

import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Games;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.repository.EditorRepository;
import com.example.tpgraphql.repository.GameRepository;
import com.example.tpgraphql.repository.StudioRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; // Remplacer par votre repository

    public Games getGames(Integer page, String genre, String platform, String studio) {
        // Création d'un objet PageRequest pour la pagination
        PageRequest pageRequest = PageRequest.of(page, 10); // Supposons une taille de page fixe de 10

        // Utilisation de la méthode du repository avec Pageable
        Page<Game> gamePage = gameRepository.findGamesByGenresAndPlatformAndStudios(genre, platform, studio, pageRequest);

        Games gamesWrapper = new Games();
        gamesWrapper.setResults(gamePage.getContent());
        // Set additional info like total pages, current page, etc.
        // Exemple : gamesWrapper.setTotalPages(gamePage.getTotalPages());

        return gamesWrapper;
    }

    public Game getGameById(String id) {
        // Logique pour récupérer un jeu par son ID
        Optional<Game> game = gameRepository.findById(Long.valueOf(id));
        return game.orElse(null);
    }

    public Game createGame(String name, List<String> genres, Integer publicationDate, List<String> editorIds, List<String> studioIds, List<String> platform) {
        // Logique pour créer un nouveau jeu
        // Ici, vous devez gérer la création des relations avec les éditeurs et les studios
        Game newGame = new Game();
        newGame.setName(name);
        newGame.setGenres(genres);
        newGame.setPublicationDate(Long.valueOf(publicationDate));
        // ... Set other fields and handle relationships
        return gameRepository.save(newGame);
    }
}