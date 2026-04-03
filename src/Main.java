import factory.GameFactory;
import models.Game;
import models.Player;
import models.Symbol;
import models.enums.GameType;
import observer.ConsoleNotifier;
import observer.Observer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TIC TAC TOE GAME ===");

        // Create game with custom board size
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (e.g., 3 for 3x3): ");
        int boardSize = scanner.nextInt();

        Game game = GameFactory.createGame(GameType.STANDARD, boardSize);

        // Add observer
        Observer notifier = new ConsoleNotifier();
        assert game != null;
        game.addObserver(notifier);

        // Create players with custom symbols
        Player player1 = new Player(1, "Aditya", new Symbol('X'));
        Player player2 = new Player(2, "Harshita", new Symbol('O'));

        game.addPlayer(player1);
        game.addPlayer(player2);

        // Play the game
        game.play();

        scanner.close();
    }
}