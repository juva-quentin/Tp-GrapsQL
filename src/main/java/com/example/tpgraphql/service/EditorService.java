package com.example.tpgraphql.service;

import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.repository.EditorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class EditorService {

    private final EditorRepository editorRepository;

    public EditorService(EditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }

    @Transactional(readOnly = true)
    public List<Editor> findAllEditors() {
        return editorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Editor findEditorById(Long id) {
        return editorRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Editor> findEditorsByGame(Game game) {
        if (game == null) {
            return Collections.emptyList();
        }
        return editorRepository.findEditorsByGames(game);
    }

}