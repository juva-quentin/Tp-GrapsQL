package com.example.tpgraphql.repository;

import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
    List<Studio> findStudiosByGames(Game game);
}