package com.example.tpgraphql.repository;

import com.example.tpgraphql.model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {
    private final List<Game> games = new ArrayList<>();

    public List<Game> findAll() {
        return games;
    }

    public Optional<Game> findById(String id) {
        return games.stream().filter(game -> game.getId().equals(id)).findFirst();
    }

    public Game save(Game game) {
        games.add(game);
        return game;
    }

    // Ajoutez d'autres méthodes si nécessaire
}