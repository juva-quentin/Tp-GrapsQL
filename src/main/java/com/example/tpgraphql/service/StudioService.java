package com.example.tpgraphql.service;

import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import com.example.tpgraphql.model.Studios;
import com.example.tpgraphql.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository; // Remplacer par votre repository de studios

    private static final int DEFAULT_PAGE_SIZE = 10; // Taille de page par défaut

    public Studios getStudios(Integer page) {
        // Utilise la taille de page par défaut si 'size' n'est pas fourni
        PageRequest pageRequest = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        Page<Studio> studioPage = studioRepository.findAll(pageRequest);

        Studios studiosWrapper = new Studios();
        studiosWrapper.setResults(studioPage.getContent());
        // Set additional info like total pages, current page, etc.

        return studiosWrapper;
    }

    public Studio getStudioById(String id) {
        // Logique pour récupérer un studio par son ID
        Optional<Studio> studio = studioRepository.findById(Long.valueOf(id));
        return studio.orElse(null);
    }

    // Ajoutez d'autres méthodes selon les besoins, par exemple pour créer, mettre à jour ou supprimer des studios
}