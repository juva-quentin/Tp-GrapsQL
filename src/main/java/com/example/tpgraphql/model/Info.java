package com.example.tpgraphql.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info {
    private int currentPage;
    private int totalPages;
    private long totalResults;

    // Getters et Setters
}