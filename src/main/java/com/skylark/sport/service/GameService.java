package com.skylark.sport.service;

import com.skylark.sport.entity.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {

    public Game SaveGame(Game game);

    public Game GetGame(Long gameId);

    public List<Game> GetAllGames();

    public void DeleteGame(Long gameId);

}
