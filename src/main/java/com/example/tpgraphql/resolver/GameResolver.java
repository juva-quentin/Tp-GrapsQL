package com.example.tpgraphql.resolver;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.tpgraphql.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameResolver implements GraphQLQueryResolver {
    private final GameService gameService;

    @Autowired
    public GameResolver(GameService gameService) {
        this.gameService = gameService;
    }

    // Query methods (e.g., games(), game(id))
}