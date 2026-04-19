class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sm = 0;
        for (int s : nums) {
            sm += s;
        }

        // If target outside possible range
        if (Math.abs(target) > sm) {
            return 0;
        }

        int offset = sm;

        int[][] dp = new int[2 * sm + 1][nums.length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, nums, target, 0, dp, offset);
    }

    public int helper(int ind, int[] nums, int target,
                      int sum, int[][] dp, int offset) {

        if (ind == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (dp[sum + offset][ind] != -1) {
            return dp[sum + offset][ind];
        }

        int plus =
            helper(ind + 1, nums, target,
                   sum + nums[ind], dp, offset);

        int minus =
            helper(ind + 1, nums, target,
                   sum - nums[ind], dp, offset);

        return dp[sum + offset][ind] = plus + minus;
    }
}