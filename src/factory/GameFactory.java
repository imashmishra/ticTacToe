package factory;

import models.Game;
import models.enums.GameType;

public class GameFactory {
    public static Game createGame(GameType gt, int boardSize) {
        if(GameType.STANDARD == gt) {
            return new Game(boardSize);
        }
        return null;
    }
}
