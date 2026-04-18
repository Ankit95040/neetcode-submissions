class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int a = helper(0, nums.length - 2, nums, dp1);

        int b = helper(1, nums.length - 1, nums, dp2);

        return Math.max(a, b);
    }

    public int helper(int ind, int last, int[] nums, int[] dp) {

        if (ind > last) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int take = nums[ind] + helper(ind + 2, last, nums, dp);

        int notTake = helper(ind + 1, last, nums, dp);

        return dp[ind] = Math.max(take, notTake);
    }
}