package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.models.*;
import TicTacToe.stratergies.winnigStratergy.ColWinningStratergy;
import TicTacToe.stratergies.winnigStratergy.DigonalWinningStratergy;
import TicTacToe.stratergies.winnigStratergy.RowWinningStratergy;
import TicTacToe.stratergies.winnigStratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeMain {
    public static void main(String[] args) {

        int dimension=3;
        List<Player>players = new ArrayList<>();
        players.add(new Player(new Symbol('X'),"Brian", PlayerType.HUMAN));
        players.add(new Bot(new Symbol('O'),"BOT",PlayerType.BOT, BotDifficultyLevel.EASY));

        List<WinningStratergy>winningStratergies = List.of(new RowWinningStratergy()
                ,new DigonalWinningStratergy()
                , new ColWinningStratergy());

        GameController gameController = new GameController();
        Game game = gameController.startGame(dimension,players,winningStratergies);

        gameController.printBoard(game);

        while (gameController.GameState(game).equals(GameState.IN_PROGRESS)){
            gameController.printBoard(game);
            gameController.makeMove(game);

        }


        System.out.println("DEBUG");

    }







}
