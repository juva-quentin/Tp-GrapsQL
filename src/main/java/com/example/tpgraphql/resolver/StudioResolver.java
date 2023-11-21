package com.example.tpgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.model.Studios;
import com.example.tpgraphql.service.GameService;
import com.example.tpgraphql.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Component
@Controller
public class StudioResolver implements GraphQLResolver<Studio> {

    @Autowired
    private StudioService studioService;

    @QueryMapping
    public Studios studios(Integer page) {

        return studioService.getStudios(page);
    }

}