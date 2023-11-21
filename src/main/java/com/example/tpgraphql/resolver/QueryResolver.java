package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.tpgraphql.model.*;
import com.example.tpgraphql.service.GameService;
import com.example.tpgraphql.service.EditorService;
import com.example.tpgraphql.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Component
@Controller
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private GameService gameService;
    @Autowired
    private EditorService editorService;
    @Autowired
    private StudioService studioService;


    public Games games(@Argument(name = "page") Integer page,
                       @Argument(name = "genre") String genre,
                       @Argument(name = "platform") String platform,
                       @Argument(name = "studio") String studio) {
        return gameService.getGames(page, genre, platform, studio);
    }


    public Game game(@Argument(name = "id") String id) {
        return gameService.getGameById(id);
    }


    public Editors editors(@Argument(name = "page") Integer page) {
        return editorService.getEditors(page);
    }


    public Editor editor(@Argument(name = "id") String id) {
        return editorService.getEditorById(id);
    }


    public Studios studios(@Argument(name = "page") Integer page) {
        return studioService.getStudios(page);
    }


    public Studio studio(@Argument(name = "id") String id) {
        return studioService.getStudioById(id);
    }
}