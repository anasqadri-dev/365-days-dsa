public class Day177 {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++)
                if (searchWord(board, word, row, column, 0)) return true;
        }
        return false;
    }
    private boolean searchWord(char[][] board, String word, int row, int column, int currentIndex) {
        if (currentIndex == word.length()) return true;
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != word.charAt(currentIndex)) return false;
        char currentCharacter = board[row][column];
        board[row][column] = '#';
        boolean found = searchWord(board, word, row - 1, column, currentIndex + 1) || searchWord(board, word, row + 1, column, currentIndex + 1) || searchWord(board, word, row, column - 1, currentIndex + 1) || searchWord(board, word, row, column + 1, currentIndex + 1);
        board[row][column] = currentCharacter;
        return found;
    }
}