package TicTacToe.models;

import TicTacToe.stratergies.winnigStratergy.WinningStratergy;

import java.util.*;

public class Game {

    private Board board;
    private List<Player>players;
    private List<Move>moves;
    private Player winner;
    private GameState gameState;
    private int nextMovePlayerIndex;

    private static Scanner scanner = new Scanner(System.in);

    private List<WinningStratergy> winningStratergies;

    public static Builder GetBuilder(){
        return new Builder();
    }

    private Game(int dimension,List<Player>players,List<WinningStratergy>winningStratergies){
        board=new Board(dimension);
        this.players=players;
        moves=new ArrayList<>();
        nextMovePlayerIndex=0;
        gameState=GameState.IN_PROGRESS;
        this.winningStratergies=winningStratergies;



    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStratergy> getWinningStratergies() {
        return winningStratergies;
    }

    public void setWinningStratergies(List<WinningStratergy> winningStratergies) {
        this.winningStratergies = winningStratergies;
    }

    public void printBoard(){
        board.printBoard();
    }

    private boolean validateMove(Move move){
        Cell cell = new Cell(move.getCell().getRow(),move.getCell().getCol());

        if(cell.getRow()<0 || cell.getRow()>=board.getDimension()||cell.getCol()<0||cell.getCol()>=board.getDimension()){
            return false;
        }

        if(!board.getBoard().get(cell.getRow()).get(cell.getCol()).getCellState().equals(CellState.EMPTY)){
            return false;
        }

        return true;


    }

    private boolean checkWinner(Move move) {
        for (WinningStratergy winningStratergy:winningStratergies) {
            if (winningStratergy.checkWinner(board, move)) {
                return true;
            }
        }

        return false;
    }

    private void removeFromWin(Move move){
        for (WinningStratergy winningStratergy:winningStratergies){
            winningStratergy.removeMove(move);

        }
    }
    private void removeFromBoard(Move move){
        Integer row = move.getCell().getRow();
        Integer col = move.getCell().getCol();
        Cell emptyCell = new Cell(row,col);
        board.getBoard().get(row).set(col,emptyCell);

    }

    public void makeMove(){
        Player currPlayer = players.get(nextMovePlayerIndex);
        System.out.println("this is "+currPlayer.getName()+"'s move:- ");

        Move move = currPlayer.makeMove(board);


        if(validateMove(move)==false){
            throw new RuntimeException("enter valid row and col ");
        }

        Cell cell = board.getBoard().get(move.getCell().getRow()).get(move.getCell().getCol());
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currPlayer);
        nextMovePlayerIndex = (nextMovePlayerIndex+1)%players.size();
        Move finalMove = new Move(currPlayer,cell);
        moves.add(finalMove);

        if(checkWinner(finalMove)){
            winner=currPlayer;
            gameState=GameState.ENDED;
            System.out.println("Game Ended. Winner = "+winner.getName());
            board.printBoard();

        } else if (moves.size()== board.getDimension() * board.getDimension()) {
            gameState = GameState.DRAW;
            System.out.println("Game Ended. Winner = Draw ");
            board.printBoard();
        }
        else {
            if(currPlayer.getPlayerType().equals(PlayerType.HUMAN)){
                System.out.println("Do u want to undo ? y/n :- ");
                String undo = scanner.next();

                if(undo.equalsIgnoreCase("y")){
                    removeFromWin(finalMove);
                    removeFromBoard(finalMove);
                     moves.removeLast();


                     Integer idx = nextMovePlayerIndex -1;
                     nextMovePlayerIndex = idx%players.size();



                }
            }
        }
    }


        public static class Builder{


            private int dimension;
            private List<Player>players;

            private List<WinningStratergy> winningStratergies;

            private Builder(){
                dimension=0;
                players=new ArrayList<>();
                winningStratergies=new ArrayList<>();
            }

            public int getDimension() {
                return dimension;
            }

            public Builder setDimension(int dimension) {
                this.dimension = dimension;
                return this;
            }

            public List<Player> getPlayers() {
                return players;
            }

            public Builder setPlayers(List<Player> players) {
                this.players = players;
                return this;
            }

            public List<WinningStratergy> getWinningStratergies() {
                return winningStratergies;
            }

            public Builder setWinningStratergies(List<WinningStratergy> winningStratergies) {
                this.winningStratergies = winningStratergies;
                return this;
            }
            private void validateDimension(){
                if(dimension<=1){
                    throw new RuntimeException("dimension is less than one at least 2 needed");
                }
            }
            private void validateBotCount(){
                int count=0;
                for(Player player:players){
                    if(player.getPlayerType().equals(PlayerType.BOT)){
                        count++;
                    }
                }
                if(count>1){
                    throw new RuntimeException("only onr bot per game is allowed");
                }
            }

            private void validateUniqueSymbols(){
                Set<Character>symbolSet = new HashSet<>();
                for (Player player:players){
                    symbolSet.add(player.getSymbol().getaChar());
                }

                if(symbolSet.size() != dimension-1){
                    throw new RuntimeException("Every player should have a unique symbol");
                }
            }

            public Game Build(){
                validateDimension();
                validateBotCount();
                validateUniqueSymbols();

                return new Game(dimension,players,winningStratergies);
            }


        }



    }




