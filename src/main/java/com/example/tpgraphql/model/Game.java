package com.example.tpgraphql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ElementCollection
    private List<String> genres;
    private Long publicationDate;
    @ManyToMany(mappedBy = "games")
    private List<Editor> editors;
    @ManyToMany(mappedBy = "games")
    private List<Studio> studios;
    @ElementCollection
    private List<String> platform;

    // Getters et Setters
}