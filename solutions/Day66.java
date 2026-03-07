public class Day66 {
    public boolean isValidSudoku(char[][] board) {
        if (!checkRows(board)) return false;
        if (!checkColumns(board)) return false;
        if (!checkBoxes(board)) return false;
        return true;
    }
    public boolean checkRows(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (seen[num]) return false;
                    seen[num] = true;
                }
            }
        }
        return true;
    }
    public boolean checkColumns(char[][] board) {
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (seen[num]) return false;
                    seen[num] = true;
                }
            }
        }
        return true;
    }
    public boolean checkBoxes(char[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                boolean[] seen = new boolean[9];
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] != '.') {
                            int num = board[i][j] - '1';
                            if (seen[num]) return false;
                            seen[num] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}