class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return helper(0,0,text1,text2,dp);
    }
    public int helper(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind1>=s1.length() | ind2>=s2.length()){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2]=1+helper(ind1+1,ind2+1,s1,s2,dp);
        }else{
            return dp[ind1][ind2]=Math.max(helper(ind1+1,ind2,s1,s2,dp), helper(ind1,ind2+1,s1,s2,dp));
        }
    }
}
