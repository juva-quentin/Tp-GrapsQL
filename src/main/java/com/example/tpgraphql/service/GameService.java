package com.example.tpgraphql.service;

import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
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

    private final GameRepository gameRepository;
    private final EditorRepository editorRepository;
    private final StudioRepository studioRepository;

    @Autowired
    public GameService(GameRepository gameRepository, EditorRepository editorRepository, StudioRepository studioRepository) {
        this.gameRepository = gameRepository;
        this.editorRepository = editorRepository;
        this.studioRepository = studioRepository;
    }

    @Transactional(readOnly = true)
    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Game> findGameById(Long id) {
        return Optional.ofNullable(gameRepository.findById(id).orElse(null));
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

    @Transactional
    public Game createGame(String name, List<String> genres, Long publicationDate, List<Long> editorIds, List<Long> studioIds, List<String> platform) {
        Game game = new Game();
        game.setName(name);
        game.setGenres(genres);
        game.setPublicationDate(publicationDate);
        game.setPlatform(platform);
        System.out.println("Creating game with name: " + name);
        // Récupérer les éditeurs et les studios par leurs identifiants
        List<Editor> editors = new ArrayList<>();
        for (Long id : editorIds) {
            editorRepository.findById(id).ifPresent(editors::add);
        }
        game.setEditors(editors);

        List<Studio> studios = new ArrayList<>();
        for (Long id : studioIds) {
            studioRepository.findById(id).ifPresent(studios::add);
        }
        game.setStudios(studios);

        return gameRepository.save(game);
    }


    @Transactional(readOnly = true)
    public List<Game> findGamesByStudio(Studio studio) {
        if (studio == null) {
            return Collections.emptyList();
        }
        return gameRepository.findGamesByStudios(studio);
    }
}