package strategy;

import models.Board;
import models.Symbol;

public interface Rules {
    boolean isValidMove(Board board, int row, int col);
    boolean checkWin(Board board, Symbol symbol);
    boolean checkDraw(Board board);
}
