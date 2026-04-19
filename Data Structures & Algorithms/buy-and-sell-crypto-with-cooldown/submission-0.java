class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

      
        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, prices, 1, dp);
    }

    public int helper(int ind, int[] prices, int state, int[][] dp) {

        if (ind >= prices.length) {
            return 0;
        }

        if (dp[ind][state] != -1) {
            return dp[ind][state];
        }

        if (state == 1) { 

            int buy =
                -prices[ind]
                + helper(ind + 1, prices, 0, dp);

            int nbuy =
                helper(ind + 1, prices, 1, dp);

            return dp[ind][state] =
                Math.max(buy, nbuy);

        } else { 

            int sell =
                prices[ind]
                + helper(ind + 2, prices, 1, dp); 

            int nsell =
                helper(ind + 1, prices, 0, dp);

            return dp[ind][state] =
                Math.max(sell, nsell);
        }
    }
}