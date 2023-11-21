package com.example.tpgraphql.service;

import com.example.tpgraphql.model.*;
import com.example.tpgraphql.repository.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EditorService {

    @Autowired
    private EditorRepository editorRepository; // Remplacer par votre repository d'éditeurs

    private static final int DEFAULT_PAGE_SIZE = 10; // Taille de page par défaut

    public Editors getEditors(Integer page) {
        PageRequest pageRequest = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        Page<Editor> editorPage = editorRepository.findAll(pageRequest);

        Editors editorsWrapper = new Editors();
        editorsWrapper.setResults(editorPage.getContent());
        // Set additional info like total pages, current page, etc.

        return editorsWrapper;
    }

    public Editor getEditorById(String id) {
        // Logique pour récupérer un éditeur par son ID
        Optional<Editor> editor = editorRepository.findById(Long.valueOf(id));
        return editor.orElse(null);
    }

}