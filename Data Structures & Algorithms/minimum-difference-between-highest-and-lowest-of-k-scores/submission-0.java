class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int r=k-1;
        int ans=Integer.MAX_VALUE;
        while(r<nums.length){
           ans=Math.min(ans,nums[r]-nums[l]);
           l++;
           r++;
        }
        return ans;
    }
}