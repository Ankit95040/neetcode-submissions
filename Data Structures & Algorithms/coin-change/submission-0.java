class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = helper(0, coins, amount, dp);

        if (ans == (int) 1e9) {
            return -1;
        }

        return ans;
    }

    public int helper(int ind, int[] coins, int amount, int[][] dp) {

        if (amount == 0) {
            return 0;
        }

        if (ind >= coins.length) {
            return (int) 1e9;
        }

        if (dp[ind][amount] != -1) {
            return dp[ind][amount];
        }

        int take = (int) 1e9;

        if (amount >= coins[ind]) {
            take = 1 + helper(ind, coins, amount - coins[ind], dp);
        }

        int notTake = helper(ind + 1, coins, amount, dp);

        return dp[ind][amount] = Math.min(take, notTake);
    }
}