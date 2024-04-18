package TicTacToe.controllers;

import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;
import TicTacToe.stratergies.winnigStratergy.WinningStratergy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player>players, List<WinningStratergy>winningStratergies){
        return Game.GetBuilder().setDimension(dimension).setPlayers(players).setWinningStratergies(winningStratergies).Build();
    }

    public void makeMove(Game game){
        game.makeMove();

    }
    public GameState GameState(Game game){
        return game.getGameState();
    }

    public void Undo(Game game){

    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void printBoard(Game game){
            game.printBoard();
    }
}
