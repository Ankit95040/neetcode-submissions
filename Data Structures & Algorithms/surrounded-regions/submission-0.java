class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        for(int[] d:vis){
            Arrays.fill(d,0);
        }
        //first row
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && vis[0][i]!=1){
                dfs(0,i,vis,board);
            }
        }
        //last row
        for(int i=0;i<m;i++){
            if(board[n-1][i]=='O' && vis[n-1][i]!=1){
                dfs(n-1,i,vis,board);
            }
        }
        // first col
         for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]!=1){
            dfs(i,0,vis,board);
           }
        }

        // last col
         for(int i=0;i<n;i++){
             if(board[i][m-1]=='O' && vis[i][m-1]!=1){
             dfs(i,m-1,vis,board);
             }
        }

       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int r,int c,int[][] vis,char[][] board){
        vis[r][c]=1;
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=r+drow[i];
            int ncol=c+dcol[i];
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,vis,board);
            }
        }
    }
}
