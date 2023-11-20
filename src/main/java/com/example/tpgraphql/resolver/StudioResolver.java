package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.service.GameService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class StudioResolver implements GraphQLResolver<Studio> {

    private final GameService gameService;

    public StudioResolver(GameService gameService) {
        this.gameService = gameService;
    }

    public List<Game> games(Studio studio) {
        return gameService.findGamesByStudio(studio);
    }
}