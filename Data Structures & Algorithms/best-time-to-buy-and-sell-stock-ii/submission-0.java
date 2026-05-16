class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return helper(0, prices, 1, dp);
    }

    public int helper(int ind, int[] prices, int buy, Integer[][] dp) {
        if (ind == prices.length) {
            return 0;
        }

        if (dp[ind][buy] != null) {
            return dp[ind][buy];
        }

        if (buy == 1) {
            int b = -prices[ind] + helper(ind + 1, prices, 0, dp);
            int nb = helper(ind + 1, prices, 1, dp);

            dp[ind][buy] = Math.max(b, nb);
        } else {
            int s = prices[ind] + helper(ind + 1, prices, 1, dp);
            int ns = helper(ind + 1, prices, 0, dp);

            dp[ind][buy] = Math.max(s, ns);
        }

        return dp[ind][buy];
    }
}