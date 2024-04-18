package TicTacToe.Factory;

import TicTacToe.models.BotDifficultyLevel;
import TicTacToe.stratergies.botPlayingStratergies.BotPlayingStratergies;
import TicTacToe.stratergies.botPlayingStratergies.EasyBotPlayingStratergy;
import TicTacToe.stratergies.botPlayingStratergies.HardBotPlayingStratergy;
import TicTacToe.stratergies.botPlayingStratergies.MediumBotPlayingStratergy;

public class BotPlayingStratergyFactory {
    public static BotPlayingStratergies getBotplayingStratergy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(botDifficultyLevel.EASY)){
            return new EasyBotPlayingStratergy();

        } else if (botDifficultyLevel.equals(botDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStratergy();

        }
        else {
            return new HardBotPlayingStratergy();
        }
    }
}
