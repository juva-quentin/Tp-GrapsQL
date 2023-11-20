package com.example.tpgraphql.resolver;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.service.EditorService;
import com.example.tpgraphql.service.GameService;
import com.example.tpgraphql.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class GameResolver implements GraphQLResolver<Game> {

    private final EditorService editorService;
    private final StudioService studioService;

    public GameResolver(EditorService editorService, StudioService studioService) {
        this.editorService = editorService;
        this.studioService = studioService;
    }

    public List<Editor> editors(Game game) {
        return editorService.findEditorsByGame(game);
    }

    public List<Studio> studios(Game game) {
        return studioService.findStudiosByGame(game);
    }
}
