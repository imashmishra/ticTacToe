package models;

import lombok.Getter;

public class Board {
    private final Symbol[][] grid;
    @Getter
    private final int size;
    @Getter
    private final Symbol emptyCell;

    public Board(int s) {
        size = s;
        emptyCell = new Symbol('-');
        grid = new Symbol[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                grid[i][j] = emptyCell;
            }
        }
    }

    public boolean isCellEmpty(int row, int col) {
        if(row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }
        return grid[row][col] == emptyCell;
    }

    public void placeMark(int row, int col, Symbol mark) {
        if(row < 0 || row >= size || col < 0 || col >= size) {
            return;
        }
        if(!isCellEmpty(row, col)) {
            return;
        }
        grid[row][col] = mark;
    }

    public Symbol getCell(int row, int col) {
        if(row < 0 || row >= size || col < 0 || col >= size) {
            return emptyCell;
        }
        return grid[row][col];
    }

    public void display() {
        System.out.print("\n  ");
        for(int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getMark() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
