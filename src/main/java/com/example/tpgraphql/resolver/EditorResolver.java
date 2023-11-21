package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Editors;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.service.EditorService;
import com.example.tpgraphql.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Component
@Controller
public class EditorResolver implements GraphQLResolver<Editor> {

    @Autowired
    private EditorService editorService;
    @QueryMapping
    public Editors editors(Integer page) {
        // Ici, la logique pour récupérer les données des éditeurs
        // par exemple, utiliser editorService pour récupérer les données et les paginer
        return editorService.getEditors(page);
    }

}