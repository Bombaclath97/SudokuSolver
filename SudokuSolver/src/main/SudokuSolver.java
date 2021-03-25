package main;

public class SudokuSolver {
    public SudokuSolver(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public int[][] solve() {
        solveAll(0, 0);
        return this.sudoku;
    }

    private boolean solveAll(int row, int col) {
        if(row == 9) {
            return true;
        }

        if(sudoku[row][col] != 0) {
            return (row==8) ? solveAll(0, col + 1) : solveAll(row + 1, col);
        }

        for(int i = 1; i <= 9; i++) {
            this.sudoku[row][col] = i;
            if(isValid(row, col)) {
                if(row==8) {
                    if(solveAll(0, col + 1)) return true;
                } else {
                    if(solveAll(row + 1, col)) return true;
                }
            }
        }
        sudoku[row][col] = 0;
        return false;
    }

    private boolean isValid(int row, int col) {
        //check if number is valid in row and column constraint
        for(int i = 0; i < 9; i++) {
            if((sudoku[row][i] == sudoku[row][col] && i != col) || (sudoku[i][col] == sudoku[row][col] && i != row)) {
                return false;
            }
        }
        //check if number is valid in 3x3 box constraint
        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3;
        for(int i = startingRow; i < startingRow + 3; i++) {
            for(int j = startingCol; i < startingCol + 3; i++) {
                if(sudoku[i][j] == sudoku[row][col] && i != row && j != col) return false;
            }
        }
        return true;
    }

    private int[][] sudoku;
}   
