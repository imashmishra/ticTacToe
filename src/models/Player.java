package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final int id;
    private final String name;
    private final Symbol symbol;
    private int score;

    public Player(int playerId, String n, Symbol s) {
        this.id = playerId;
        name = n;
        symbol = s;
        score = 0;
    }

    public void incrementScore() {
        score++;
    }
}
