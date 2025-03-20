package com.skylark.sport.service;


import com.skylark.sport.entity.GamePlayer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GamePlayerService {

    public GamePlayer saveGamePlayer(GamePlayer gamePlayer);

    public GamePlayer getGamePlayerById(Long id);

    public List<GamePlayer> getAllGamePlayer();

    public void deleteGamePlayerById(Long id);

}
