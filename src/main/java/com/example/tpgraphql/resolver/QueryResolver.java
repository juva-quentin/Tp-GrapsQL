package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.service.GameService;
import com.example.tpgraphql.service.EditorService;
import com.example.tpgraphql.service.StudioService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private final GameService gameService;
    private final EditorService editorService;
    private final StudioService studioService;

    public QueryResolver(GameService gameService, EditorService editorService, StudioService studioService) {
        this.gameService = gameService;
        this.editorService = editorService;
        this.studioService = studioService;
    }

    public List<Game> games(Integer page, String genre, String platform, String studio) {
        // Utilisez gameService pour implémenter la logique
        return gameService.findGames(page, genre, platform, studio);
    }

    public Game game(Long id) {
        return gameService.findGameById(id);
    }

    public List<Editor> editors() {
        return editorService.findAllEditors();
    }

    public Editor editor(Long id) {
        return editorService.findEditorById(id);
    }

    public List<Studio> studios() {
        return studioService.findAllStudios();
    }

    public Studio studio(Long id) {
        return studioService.findStudioById(id);
    }
}
