package com.example.tpgraphql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "studio_game", joinColumns = @JoinColumn(name = "studio_id"), inverseJoinColumns = @JoinColumn(name = "game_id"))
    private List<Game> games;

    // Getters et Setters
}