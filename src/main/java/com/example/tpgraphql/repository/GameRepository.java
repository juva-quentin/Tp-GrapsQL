package com.example.tpgraphql.repository;

import com.example.tpgraphql.model.Editor;
import com.example.tpgraphql.model.Game;
import com.example.tpgraphql.model.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Page<Game> findGamesByGenresAndPlatformAndStudios(String genres, String platform, String studio, Pageable pageable);


}
