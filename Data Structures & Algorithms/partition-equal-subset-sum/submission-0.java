class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
       
        for(int n:nums){
            sum+=n;
        }
        if((sum & 1)==1){
            return false;
        }
        int target=sum/2;
        int temp=0;
         int[][] dp=new int[sum][nums.length];
         for(int[] ele:dp){
            Arrays.fill(ele,-1);
         }
        temp= helper(0,target,nums,dp);
        if(temp==0){
            return false;
        }
        return true;

    }
    public int helper(int ind,int target,int[] nums,int[][] dp){
        if(target==0){
            return 1;
        }
        if(ind>=nums.length){
            return 0;
        }
        if(dp[target][ind]!=-1){
            return dp[target][ind];
        }
        int take=0;
        if(target>=nums[ind]){
         take=helper(ind+1,target-nums[ind],nums,dp);
        }
        int nTake=helper(ind+1,target,nums,dp);
        return dp[target][ind]=take+nTake;
    }
}
