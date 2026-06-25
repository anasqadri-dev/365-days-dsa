public class Day176 {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++)
                board[row][column] = '.';
        }
        return countSolutions(board, 0);
    }
    private int countSolutions(char[][] board, int currentRow) {
        if (currentRow == board.length) return 1;
        int totalSolutions = 0;
        for (int column = 0; column < board.length; column++) {
            if (isSafe(board, currentRow, column)) {
                board[currentRow][column] = 'Q';
                totalSolutions += countSolutions(board, currentRow + 1);
                board[currentRow][column] = '.';
            }
        }
        return totalSolutions;
    }
    private boolean isSafe(char[][] board, int row, int column) {
        for (int i = 0; i < row; i++)
            if (board[i][column] == 'Q') return false;
        int i = row - 1;
        int j = column - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = row - 1;
        j = column + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}