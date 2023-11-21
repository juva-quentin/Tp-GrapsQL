package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private final GameService gameService;

    @Autowired
    public MutationResolver(GameService gameService) {
        this.gameService = gameService;
    }

    @QueryMapping
    public Game createGame(String name, List<String> genres, Long publicationDate, List<Long> editorIds, List<Long> studioIds, List<String> platform) {
       System.out.println("Mutation resolver");
        return gameService.createGame(name, genres, publicationDate, editorIds, studioIds, platform);
    }

}