package com.skylark.sport.repository;

import com.skylark.sport.entity.GamePlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GamePlayerRepository extends JpaRepository<GamePlayer, Long> {
}
