class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        int a=helper(0,cost,dp);
        int b=helper(1,cost,dp);
         return Math.min(a,b);
    }
    public int helper(int ind,int[] cost,int[] dp){
        if(ind==cost.length-1){
            return cost[ind];
        }
        if(ind==cost.length){
            return 0;
        }
        if(ind>cost.length){
            return (int)1e9;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int one=cost[ind]+helper(ind+1,cost,dp);
        int two=cost[ind]+helper(ind+2,cost,dp);
        return dp[ind]=Math.min(one,two);
    }
}
