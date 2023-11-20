package com.example.tpgraphql.repository;

import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
    List<Editor> findEditorsByGames(Game game);
}