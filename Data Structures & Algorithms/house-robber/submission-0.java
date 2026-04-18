class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums,dp);
    }
    public int helper(int ind,int[] nums,int[] dp){
        if(ind==nums.length-1){
            return nums[ind];
        }
        if(ind>=nums.length){
              return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int take=nums[ind]+helper(ind+2,nums,dp);
        int notT=helper(ind+1,nums,dp);
        return dp[ind]=Math.max(take,notT);
    }
}
