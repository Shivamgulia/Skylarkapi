package com.skylark.sport.util;

import com.skylark.sport.dto.Game.GetGameDto;
import com.skylark.sport.entity.Game;
import com.skylark.sport.entity.GamePlayer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class GameUtil {

    public Game getGameDtoToGame (GetGameDto game) {
        Game newGame = new Game();
        ArrayList<GamePlayer> players = new ArrayList<>();

        int team1Size = game.getPlayers1().size();
        int team2Size = game.getPlayers2().size();


        int score1 = 0;
        int score2 = 0;

        for(int i = 0; i < team1Size; i++) {
            GamePlayer temp =  new GamePlayer();

            temp.setPlayerName(game.getPlayers1().get(i));
            temp.setPoints(game.getScores1().get(i));
            temp.setTeam(false);

            score1 += temp.getPoints();

            players.add(temp);
        }

        for(int i = 0; i < team2Size; i++) {
            GamePlayer temp =  new GamePlayer();

            temp.setPlayerName(game.getPlayers2().get(i));
            temp.setPoints(game.getScores2().get(i));
            temp.setTeam(true);

            score2 += temp.getPoints();

            players.add(temp);
        }

        newGame.setPlayers(players);
        newGame.setTeam1Score(score1);
        newGame.setTeam2Score(score2);
        newGame.setTitle(game.getGameName());
        newGame.setTeam1("Blue");
        newGame.setTeam2("Red");

        return newGame;
    }

    public GetGameDto gameToGetGameDto (Game game) {

        GetGameDto getGameDto = new GetGameDto();

        getGameDto.setGameName(game.getTitle());

        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<Integer> score1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<Integer> score2 = new ArrayList<>();


        int allPlayersLength = game.getPlayers().size();

        for(int i = 0; i < allPlayersLength; i++) {
            GamePlayer temp = game.getPlayers().get(i);

            if(temp.isTeam()) {

                player2.add(temp.getPlayerName());
                score2.add(temp.getPoints());

            }
            else {
                player1.add(temp.getPlayerName());
                score1.add(temp.getPoints());
            }


        }

        getGameDto.setPlayers2(player2);
        getGameDto.setPlayers1(player1);
        getGameDto.setScores1(score1);
        getGameDto.setScores2(score2);


        return getGameDto;
    }

}
