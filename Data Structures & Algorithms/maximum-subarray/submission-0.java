class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int ans=-(int)1e9;
        for(int n:nums){
            sum+=n;
            ans=Math.max(sum,ans);
            if(sum<0){
                sum=0;
            }

        }
        return ans;
    }
}
