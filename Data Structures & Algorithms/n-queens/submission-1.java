class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // fill board with '.'
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, result, n);

        return result;
    }

    public void backtrack(int row, char[][] board, List<List<String>> result, int n) {
        if(row == n) {
            List<String> temp = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }

        for(int col = 0; col < n; col++) {
            if(isValid(row, col, board, n)) {
                board[row][col] = 'Q';

                backtrack(row + 1, board, result, n);

                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(int r, int c, char[][] board, int n) {

        // check column
        for(int i = 0; i < r; i++) {
            if(board[i][c] == 'Q') {
                return false;
            }
        }

        // diagonal right (upper-right)
        int row = r;
        int col = c;

        while(row >= 0 && col < n) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row--;
            col++;
        }

        // diagonal left (upper-left)
        row = r;
        col = c;

        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        return true;
    }
}