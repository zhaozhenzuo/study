package algo;

public class A {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!isValid(board, i, j))
                    return false;
            }
        }
        return true;
    }
    private static  boolean isValid(char[][] board, int i, int j) {
        for (int m = 0; m < 9; m++) {
            if (m != j && board[i][m] == board[i][j]) // row
                return false;
            if (m != i && board[m][j] == board[i][j]) // column
                return false;
        }
        for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) { // 3 * 3 grid
            for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
                if (m != i && n != j && board[m][n] == board[i][j])
                    return false;
            }
        }
        return true;
    }
}
