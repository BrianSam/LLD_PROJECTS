package TicTacToe.models;

import TicTacToe.Factory.BotPlayingStratergyFactory;
import TicTacToe.stratergies.botPlayingStratergies.BotPlayingStratergies;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStratergies botPlayingStratergies;


    public Bot(Symbol symbol, String name, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStratergies = BotPlayingStratergyFactory.getBotplayingStratergy(botDifficultyLevel);
    }
    public Move makeMove(Board board){
        return  botPlayingStratergies.makeMove(board);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStratergies getBotPlayingStratergies() {
        return botPlayingStratergies;
    }

    public void setBotPlayingStratergies(BotPlayingStratergies botPlayingStratergies) {
        this.botPlayingStratergies = botPlayingStratergies;
    }
}
