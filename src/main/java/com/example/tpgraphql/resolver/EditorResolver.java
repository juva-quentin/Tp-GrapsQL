package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class EditorResolver implements GraphQLQueryResolver {
    private final EditorService editorService;

    @Autowired
    public EditorResolver(EditorService editorService) {
        this.editorService = editorService;
    }

    // Query methods (e.g., games(), game(id))
}