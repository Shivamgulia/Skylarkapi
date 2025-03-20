package com.skylark.sport.auth;

import com.skylark.sport.dto.Game.GetGameDto;
import com.skylark.sport.entity.Game;
import com.skylark.sport.entity.GamePlayer;
import com.skylark.sport.service.GameService;
import com.skylark.sport.util.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameUtil gameUtil;


    @PostMapping("/games")
    public void saveGame(@RequestBody GetGameDto game) {
        gameService.SaveGame(gameUtil.getGameDtoToGame(game));
    }


    @GetMapping("/games")
    public List<GetGameDto> getAllGames() {
        List<Game> games = gameService.GetAllGames();
        List<GetGameDto> gameDtos = new ArrayList<>();
        for(Game game : games) {
            GetGameDto temp = gameUtil.gameToGetGameDto(game);
            gameDtos.add(temp);
        }
        return gameDtos;

    }

}
