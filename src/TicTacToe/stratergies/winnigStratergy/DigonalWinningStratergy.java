package TicTacToe.stratergies.winnigStratergy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DigonalWinningStratergy implements WinningStratergy{

    private final Map<Character,Integer>leftDiagonal = new HashMap<>();
    private final Map<Character,Integer>rightDiagonal = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        Character playerChar = move.getPlayer().getSymbol().getaChar();

        Integer row = move.getCell().getRow();
        Integer col = move.getCell().getCol();

        if(row == col){
            if(!leftDiagonal.containsKey(playerChar)){
                leftDiagonal.put(playerChar,0);
            }
            leftDiagonal.put(playerChar,leftDiagonal.get(playerChar)+1);


        }
        if(row+col == board.getDimension()-1){

            if(!rightDiagonal.containsKey(playerChar)){
                rightDiagonal.put(playerChar,0);
            }
            rightDiagonal.put(playerChar,rightDiagonal.get(playerChar)+1);

        }

       if(rightDiagonal.containsKey(playerChar)) {
           if(rightDiagonal.get(playerChar).equals(board.getDimension())){
               return true;
           }

       }
       if(leftDiagonal.containsKey(playerChar)){
           if (leftDiagonal.get(playerChar).equals(board.getDimension())){
               return true;
           }
       }
        return false;

    }

    @Override
    public void removeMove(Move move) {
        Character player = move.getPlayer().getSymbol().getaChar();


        if(rightDiagonal.containsKey(player)){
            if(rightDiagonal.get(player).intValue()>0){
                rightDiagonal.put(player,rightDiagonal.get(player)-1);

            }
        }
        if(leftDiagonal.containsKey(player)){
            if(leftDiagonal.get(player).intValue()>0){
                leftDiagonal.put(player,leftDiagonal.get(player)-1);

            }
        }
    }
}
