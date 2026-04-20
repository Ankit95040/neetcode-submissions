class Solution {

    int area = 0;   

    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]==1 && vis[i][j]!=1){

                    area = 0;          

                    dfs(i,j,grid,vis);

                    ans = Math.max(ans, area);
                }
            }
        }

        return ans;
    }

    public void dfs(int r,int c,int[][] grid,int[][] vis){

        vis[r][c] = 1;

        area++;     

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        for(int i=0;i<4;i++){

            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            if(nrow>=0 && nrow<grid.length &&
               ncol>=0 && ncol<grid[0].length &&
               vis[nrow][ncol]!=1 &&
               grid[nrow][ncol]==1){

                dfs(nrow,ncol,grid,vis);
            }
        }
    }
}