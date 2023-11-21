package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Component
public class EditorResolver implements GraphQLResolver<Editor> {

    @QueryMapping
    public List<Game> games(Editor editor) {

        return editor.getGames();
    }
}