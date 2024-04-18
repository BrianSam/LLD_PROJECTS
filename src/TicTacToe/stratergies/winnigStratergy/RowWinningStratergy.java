package TicTacToe.stratergies.winnigStratergy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStratergy implements WinningStratergy{

    private final Map<Integer, HashMap<Character,Integer>>rowMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        Character playerChar = move.getPlayer().getSymbol().getaChar();

        Integer row = move.getCell().getRow();
        Integer col =move.getCell().getCol();

        if(!rowMaps.containsKey(row)){
            rowMaps.put(row,new HashMap<>());
        }

        if(!rowMaps.get(row).containsKey(playerChar)){
            rowMaps.get(row).put(playerChar,0);
        }

        rowMaps.get(row).put(playerChar,rowMaps.get(row).get(playerChar)+1);



       return rowMaps.get(row).get(playerChar).equals(board.getDimension());





    }

    @Override
    public void removeMove(Move move) {
        Character player = move.getPlayer().getSymbol().getaChar();
        Integer row = move.getCell().getRow();

        if(rowMaps.get(row).get(player).intValue()>0){
            rowMaps.get(row).put(player,rowMaps.get(row).get(player)-1);
        }
    }
}
