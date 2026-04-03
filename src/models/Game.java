package models;

import lombok.Getter;
import observer.Observer;
import strategy.Rules;
import strategy.StandardRules;

import java.util.*;

@Getter
public class Game {
    private final Board board;
    private final Deque<Player> players;
    private final Rules rules;
    private final List<Observer> observers;
    private boolean gameOver;

    public Game(int boardSize) {
        board = new Board(boardSize);
        players = new ArrayDeque<>();
        rules = new StandardRules();
        observers = new ArrayList<>();
        gameOver = false;
    }

    public void addPlayer(Player p) {
        players.addLast(p);
    }

    public void removePlayer(Player p) {
        players.removeLast();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notify(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void play() {
        if(players.size() < 2) {
            System.out.println("Need at least 2 players!");
            return;
        }

        notify("Tic Tac Toe Game Started!");

        Scanner scanner = new Scanner(System.in);

        while(!gameOver) {
            board.display();

            // Take out the current player from dequeue
            Player currentPlayer = players.peekFirst();
            System.out.print(currentPlayer.getName() + " (" + currentPlayer.getSymbol().getMark() + ") - Enter row and column: ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // check if move is valid
            if(rules.isValidMove(board, row, col)) {
                board.placeMark(row, col, currentPlayer.getSymbol());
                notify(currentPlayer.getName() + " played (" + row + "," + col + ")");

                if(rules.checkWin(board, currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println(currentPlayer.getName() + " wins!");
                    currentPlayer.incrementScore();

                    notify(currentPlayer.getName() + " wins!");

                    gameOver = true;
                }
                else if(rules.checkDraw(board)) {
                    board.display();

                    System.out.println("It's a draw!");
                    notify("Game is Draw!");

                    gameOver = true;
                }
                else {
                    // Move player to back of queue
                    players.removeFirst();
                    players.addLast(currentPlayer);
                }
            }
            else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }
}
