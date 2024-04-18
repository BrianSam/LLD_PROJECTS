package TicTacToe.stratergies.botPlayingStratergies;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.CellState;
import TicTacToe.models.Move;

import java.util.List;

public class EasyBotPlayingStratergy implements BotPlayingStratergies{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row:board.getBoard()){
            for(Cell cell:row){

                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(null,cell);


                }
            }
        }
        return null;
    }
}
