class Solution {
    public int longestPalindromeSubseq(String s) {
    String t= new StringBuilder(s).reverse().toString();
     int[][] dp=new int[t.length()][t.length()];
     for(int[] ele:dp){
        Arrays.fill(ele,-1);
     }
        return helper(s.length()-1,t.length()-1,s,t,dp);
    }
    public int helper(int i,int j,String s,String t,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= 1+helper(i-1,j-1,s,t,dp);
        }else{
            return dp[i][j]= Math.max(helper(i-1,j,s,t,dp),helper(i,j-1,s,t,dp));
        }
    }
}