package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.service.GameService;
import com.example.tpgraphql.service.EditorService;
import com.example.tpgraphql.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Optional;


import java.util.List;

@Component
@Controller
public class QueryResolver implements GraphQLQueryResolver {

    private final GameService gameService;
    private final EditorService editorService;
    private final StudioService studioService;

    @Autowired
    public QueryResolver(GameService gameService, EditorService editorService, StudioService studioService) {
        this.gameService = gameService;
        this.editorService = editorService;
        this.studioService = studioService;
    }

    @QueryMapping
    public List<Game> games() {
        return gameService.findAllGames();
    }

    @QueryMapping
    public Game game(Long id) {
        Optional<Game> game = gameService.findGameById(id);
        return game.orElse(null);
    }
    @QueryMapping
    public List<Editor> editors() {
        return editorService.findAllEditors();
    }

    @QueryMapping
    public Editor editor(Long id) {
        Optional<Editor> editor = editorService.findEditorById(id);
        return editor.orElse(null);
    }

    @QueryMapping
    public List<Studio> studios() {
        return studioService.findAllStudios();
    }

    @QueryMapping
    public Studio studio(Long id) {
        Optional<Studio> studio = studioService.findStudioById(id);
        return studio.orElse(null);
    }
}