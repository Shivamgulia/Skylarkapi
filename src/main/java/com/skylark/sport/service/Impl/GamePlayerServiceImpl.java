package com.skylark.sport.service.Impl;

import com.skylark.sport.entity.GamePlayer;
import com.skylark.sport.repository.GamePlayerRepository;
import com.skylark.sport.service.GamePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamePlayerServiceImpl implements GamePlayerService {

    @Autowired
    public GamePlayerRepository gamePlayerRepository;

    @Override
    public GamePlayer saveGamePlayer(GamePlayer gamePlayer) {
        return gamePlayerRepository.save(gamePlayer);
    }

    @Override
    public GamePlayer getGamePlayerById(Long id) {

        Optional<GamePlayer> player = gamePlayerRepository.findById(id);

        return player.orElse(null);

    }

    @Override
    public List<GamePlayer> getAllGamePlayer() {
        return gamePlayerRepository.findAll();
    }

    @Override
    public void deleteGamePlayerById(Long id) {
         gamePlayerRepository.deleteById(id);
    }
}
