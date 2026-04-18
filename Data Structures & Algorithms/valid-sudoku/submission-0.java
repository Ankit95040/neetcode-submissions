class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(helper(i,j,board,board[i][j])==false){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean helper(int i,int j,char[][] board,char c){
        //row
        for(int k=0;k<9;k++){
            if(j==k){
                continue;
            }
            if(board[i][k]==c){
                return false;
            }

        }
        //col
        for(int l=0;l<9;l++){
             if(i==l){
                continue;
             }
       
            if(board[l][j]==c){
                return false;
            }

        }
        int n=i/3;
        int m=j/3;
        for(int o=n*3;o<n*3+3;o++){
            for(int z=m*3;z<m*3+3;z++){
                if(o==i && z==j){
                    continue;
                }
                if(board[o][z]==c){
                    return false;
                }
            }
        }
        return true;


    }
}
