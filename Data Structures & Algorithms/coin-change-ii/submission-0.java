class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return helper(0,amount,coins,dp);
    }
    public int helper(int ind,int amount,int[] coins,int[][] dp){
        if(amount==0){
            return 1;
        }
        
        if (ind>=coins.length){
            return 0;
        }
        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        int take=0;
        if(amount>=coins[ind]){
         take=helper(ind,amount-coins[ind],coins,dp);
        }
        
        int nTake=helper(ind+1,amount,coins,dp);
        return dp[ind][amount] =take+nTake;

    }
}
