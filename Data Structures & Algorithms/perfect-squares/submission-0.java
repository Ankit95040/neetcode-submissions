class Solution {

    public int numSquares(int n) {

        int[][] dp = new int[n + 1][n + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return helper(n, 1, 0, dp);
    }

    public int helper(int n, int ind, int sum, int[][] dp){

        if(sum == n){
            return 0;
        }

        if(sum > n){
            return (int)1e9;
        }

        if(ind * ind > n){
            return (int)1e9;
        }

        if(dp[ind][sum] != -1){
            return dp[ind][sum];
        }

        int take = 1 + helper(n, ind, sum + ind * ind, dp);

        int ntake = helper(n, ind + 1, sum, dp);

        return dp[ind][sum] = Math.min(take, ntake);
    }
}