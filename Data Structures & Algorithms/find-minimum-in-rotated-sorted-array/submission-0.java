class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int min=(int)1e9;
        while(l<=r){
            int mid=l+(r-l)/2;
            //left sorted
            if(nums[mid]>=nums[l]){
              min=Math.min(min,nums[l]);
              l=mid+1;
              //right sorted
            }else{
                min=Math.min(min,nums[mid]);
                r=mid-1;
            }
        }
        return min;
    }
}
