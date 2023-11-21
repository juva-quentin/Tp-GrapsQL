package com.example.tpgraphql.resolver;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Games;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.service.EditorService;
import com.example.tpgraphql.service.GameService;
import com.example.tpgraphql.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Component
@Controller
public class GameResolver implements GraphQLResolver<Game> {

    @Autowired
    private GameService gameService;
    @QueryMapping
    public Game game(@Argument Long id) {
        // Récupérer un jeu spécifique par son ID
        return gameService.getGameById(String.valueOf(id));
    }


}
