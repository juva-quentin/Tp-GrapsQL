package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.service.GameService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Component
public class StudioResolver implements GraphQLResolver<Studio> {

    @QueryMapping
    public List<Game> games(@Argument Studio studio) {
        // Implémentation pour récupérer les jeux d'un studio
        return studio.getGames();
    }
}