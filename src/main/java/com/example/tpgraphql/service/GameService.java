package com.example.tpgraphql.service;

import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Optional<Game> findById(String id) {
        return gameRepository.findById(id);
    }

    // Ajoutez d'autres méthodes de service si nécessaire
}