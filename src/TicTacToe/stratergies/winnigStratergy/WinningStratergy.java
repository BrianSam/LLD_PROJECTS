package TicTacToe.stratergies.winnigStratergy;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Player;

public interface WinningStratergy {

    boolean checkWinner(Board board, Player player, Cell cell);
}
