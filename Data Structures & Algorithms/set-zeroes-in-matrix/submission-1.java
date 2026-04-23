class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] vis=new int[n][m];
        for(int[] ele:vis){
            Arrays.fill(ele,-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    helper(vis,i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        

    }
    public void helper(int[][] vis,int i,int j){
        int[] row=vis[i];
        Arrays.fill(row,0);
        for(int k=0;k<vis.length;k++){
            vis[k][j]=0;
        }
    }
}
