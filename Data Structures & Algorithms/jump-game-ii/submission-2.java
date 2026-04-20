class Solution {

    public int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return helper(0, nums, dp);
    }

    public int helper(int ind, int[] nums, int[] dp) {

        if (ind >= nums.length)
            return (int) 1e9;

        if (ind == nums.length - 1)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int ans = (int) 1e9;

        for (int i = 1; i <= nums[ind]; i++) {

            int jum = 1 + helper(ind + i, nums, dp);

            ans = Math.min(ans, jum);
        }

        return dp[ind] = ans;
    }
}