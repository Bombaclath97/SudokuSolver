package main;

public class Main {
    public static void main(String[] args) {
        int [][] sudoku =   {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                            {6, 0, 0, 1, 9, 5, 0, 0, 0},
                            {0, 9, 8, 0, 0, 0, 0, 6, 0},
                            {8, 0, 0, 0, 6, 0, 0, 0, 3},
                            {4, 0, 0, 8, 0, 3, 0, 0, 1},
                            {7, 0, 0, 0, 2, 0, 0, 0, 6}, 
                            {0, 6, 0, 0, 0, 0, 2, 8, 0}, 
                            {0, 0, 0, 4, 1, 9, 0, 0, 5},
                            {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        SudokuSolver sudokuSolver = new SudokuSolver(sudoku);
        int[][] solved = sudokuSolver.solve();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(solved[i][j] + " ");
            }
            System.out.println();
        }
    }
}
