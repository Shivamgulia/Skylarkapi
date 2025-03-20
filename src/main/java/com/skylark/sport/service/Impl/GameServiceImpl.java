package com.skylark.sport.service.Impl;

import com.skylark.sport.entity.Game;
import com.skylark.sport.repository.GameRepository;
import com.skylark.sport.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    public GameRepository gameRepository;

    @Override
    public Game SaveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game GetGame(Long gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        if(game.isPresent()){
            return game.get();
        }
        return null;
    }

    @Override
    public List<Game> GetAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public void DeleteGame(Long gameId) {
        gameRepository.deleteById(gameId);
    }
}
