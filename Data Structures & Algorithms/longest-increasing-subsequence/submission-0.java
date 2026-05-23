class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(0, -1, nums,dp);
    }
    public int helper(int ind, int prev, int[] nums,int[][] dp) {
        if (ind == nums.length) {
            return 0;
        }
        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        int nTake = 0 + helper(ind + 1, prev, nums,dp);
       
        int take = 0;
        if (prev == -1 || nums[ind] > nums[prev]) {
            take = 1 + helper(ind + 1, ind, nums,dp);
        }
        return dp[ind][prev+1]= Math.max(take, nTake);
    }
}
