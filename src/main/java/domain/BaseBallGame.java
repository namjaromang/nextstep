package domain;

import domain.exception.CannotStartGameException;

import java.util.List;

public class BaseBallGame {

    private GameStatus gameStatus;

    private BaseBallGame(List<Player> players, GameRule gameRule) {
       if(gameStatus != null) {
           throw new CannotStartGameException();
       }
       this.gameStatus = GameStatus.READY;
    }

    public static BaseBallGame setUpGame(List<Player> players, GameRule gameRule) {
        return new BaseBallGame(players, gameRule);
    }

    public void play() {
        if(gameStatus != GameStatus.READY) {
            throw new CannotStartGameException();
        }
        //게임 시작 기능
    }

    public void end() {
        if(gameStatus != GameStatus.PLAY) {
            throw new CannotStartGameException();
        }
        //게임 종료 기능
        this.gameStatus = GameStatus.END;
    }




}
