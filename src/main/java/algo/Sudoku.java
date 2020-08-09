package algo;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        char[][] bord = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {
                '.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {
                '4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {
                '.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {
                '.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean r = sudoku.isValidSudoku(bord);
        System.out.println(r);
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        return isValidDfs(board);
    }

    private boolean isValidDfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(c, i, j, board)) {
                            board[i][j] = c;
                            if (isValidDfs(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char value, int row, int col, char[][] bord) {
        for (int i = 0; i < 9; i++) {
            if ((row != i)  && bord[i][col] != '.' && bord[i][col] == value) {
                //当前列已经存在
                return false;
            }
            if (col != i && bord[row][i] != '.' && bord[row][i] == value) {
                //当前行已经存在
                return false;
            }

            int iIndex = 3 * (row / 3) + i / 3;
            int jIndex = 3 * (col / 3) + i % 3;
            if(iIndex!=row && jIndex != col){
                if (bord[iIndex][jIndex] != '.' && bord[iIndex][jIndex] == value) {
                    return false;
                }
            }
        }
        return true;
    }

}
