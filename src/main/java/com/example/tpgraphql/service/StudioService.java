package com.example.tpgraphql.service;

import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.repository.StudioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudioService {

    private final StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Transactional(readOnly = true)
    public List<Studio> findAllStudios() {
        return studioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Studio> findStudioById(Long id) {
        return Optional.ofNullable(studioRepository.findById(id).orElse(null));
    }

    @Transactional(readOnly = true)
    public List<Studio> findStudiosByGame(Game game) {
        if (game == null) {
            return Collections.emptyList();
        }
        return studioRepository.findStudiosByGames(game);
    }
}