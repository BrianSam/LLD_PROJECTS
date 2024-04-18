package TicTacToe.stratergies.winnigStratergy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStratergy implements WinningStratergy{

    private final Map<Integer, HashMap<Character,Integer>>colMap = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        Character playerChar = move.getPlayer().getSymbol().getaChar();

        Integer col = move.getCell().getCol();

        if(!colMap.containsKey(col)){
            colMap.put(col,new HashMap<>());
        }
        if(!colMap.get(col).containsKey(playerChar)){
            colMap.get(col).put(playerChar,0);
        }

        colMap.get(col).put(playerChar,(colMap.get(col).get(playerChar))+1);



        return colMap.get(col).get(playerChar).equals(board.getDimension());


    }
}
