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
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Component
@Controller
public class GameResolver implements GraphQLResolver<Game> {

    @QueryMapping
    public List<Editor> editors(Game game) {
        // Implémentation pour récupérer les éditeurs d'un jeu
        return game.getEditors();
    }

    @QueryMapping
    public List<Studio> studios(Game game) {
        // Implémentation pour récupérer les studios d'un jeu
        return game.getStudios();
    }
}
