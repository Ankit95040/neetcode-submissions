class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int[] e:vis){
            Arrays.fill(e,0);
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    count++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int[][] vis,int r,int c){
        vis[r][c]=1;
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=r+drow[i];
            int ncol=c+dcol[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0 ){
                dfs(grid,vis,nrow,ncol);
            }
        }
    }
}
