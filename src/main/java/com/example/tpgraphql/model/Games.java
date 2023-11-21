package com.example.tpgraphql.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Games {
    private Info infos;
    private List<Game> results;

    // Getters et Setters
}
