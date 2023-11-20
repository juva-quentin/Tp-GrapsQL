package com.example.tpgraphql.service;

import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.repository.GameRepository;
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

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Game findGameById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Game> findGames(Integer page, String genre, String platform, String studio) {
        Specification<Game> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (genre != null) {
                predicates.add(criteriaBuilder.like(root.join("genres"), "%" + genre + "%"));
            }
            if (platform != null) {
                predicates.add(criteriaBuilder.like(root.join("platforms"), "%" + platform + "%"));
            }
            if (studio != null) {
                predicates.add(criteriaBuilder.equal(root.join("studios").get("name"), studio));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Pageable pageable = PageRequest.of(page != null ? page : 0, 10); // 10 jeux par page, par exemple
        Page<Game> resultPage = gameRepository.findAll(spec, pageable);
        return resultPage.getContent();
    }

    @Transactional(readOnly = true)
    public List<Game> findGamesByEditor(Editor editor) {
        if (editor == null) {
            return Collections.emptyList();
        }
        return gameRepository.findGamesByEditors(editor);
    }

    @Transactional(readOnly = true)
    public List<Game> findGamesByStudio(Studio studio) {
        if (studio == null) {
            return Collections.emptyList();
        }
        return gameRepository.findGamesByStudios(studio);
    }
}