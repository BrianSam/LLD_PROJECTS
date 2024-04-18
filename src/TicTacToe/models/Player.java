package TicTacToe.models;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private String name;
    private PlayerType playerType;

    private  static Scanner scanner = new Scanner(System.in);

    public Player(Symbol symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;

    }

    public Move makeMove(Board board){

        System.out.println("enter row :- ");
        Integer row = scanner.nextInt();
        System.out.println("enter col :- ");
        Integer col = scanner.nextInt();

        Cell cell = new Cell(row,col);

        return new Move(this,cell);

    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
