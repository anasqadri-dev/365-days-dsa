public class Day175 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++)
                board[row][column] = '.';
        }
        placeQueens(board, 0, answer);
        return answer;
    }
    private void placeQueens(char[][] board, int currentRow, List<List<String>> answer) {
        if (currentRow == board.length) {
            List<String> solution = new ArrayList<>();
            for (int row = 0; row < board.length; row++)
                solution.add(new String(board[row]));
            answer.add(solution);
            return;
        }
        for (int column = 0; column < board.length; column++) {
            if (isSafe(board, currentRow, column)) {
                board[currentRow][column] = 'Q';
                placeQueens(board, currentRow + 1, answer);
                board[currentRow][column] = '.';
            }
        }
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