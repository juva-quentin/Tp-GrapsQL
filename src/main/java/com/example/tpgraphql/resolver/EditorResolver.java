package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EditorResolver implements GraphQLResolver<Editor> {

    private final GameService gameService;

    public EditorResolver(GameService gameService) {
        this.gameService = gameService;
    }

    public List<Game> games(Editor editor) {
        return gameService.findGamesByEditor(editor);
    }
}