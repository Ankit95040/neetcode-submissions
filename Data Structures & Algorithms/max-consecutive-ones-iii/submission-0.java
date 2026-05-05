class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int count=0;
        int size=-(int)1e9;
        while(r<nums.length){
            if(nums[r]==0){
                count++;
            }
            while(count>k){
                if(nums[l]==0){
                    count--;
                }
                l++;
            }
            size=Math.max(size,r-l+1);
            r++;

        }
        return size;
    }
}