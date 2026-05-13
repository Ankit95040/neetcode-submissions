class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(board[i][j] == word.charAt(0)) {
                    vis[i][j] = 1;

                    if(backtrack(i, j, board, word, 1, vis)) {
                        return true;
                    }

                    vis[i][j] = 0;
                }
            }
        }

        return false;
    }

    public boolean backtrack(int i, int j, char[][] board,
                             String word, int ind, int[][] vis) {

        if(ind == word.length()) {
            return true;
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int x = 0; x < 4; x++) {
            int nr = i + dr[x];
            int nc = j + dc[x];

            if(nr >= 0 && nr < board.length &&
               nc >= 0 && nc < board[0].length &&
               vis[nr][nc] != 1 &&
               board[nr][nc] == word.charAt(ind)) {

                vis[nr][nc] = 1;

                if(backtrack(nr, nc, board, word, ind + 1, vis)) {
                    return true;
                }

                vis[nr][nc] = 0;
            }
        }

        return false;
    }
}