package TicTacToe.stratergies.botPlayingStratergies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public interface BotPlayingStratergies {
   Move makeMove(Board board);
}
