class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0){
            return 0;
        }
        int n=nums[0];
       int count=1;
        int ans=1;
       
        for(int i=1;i<nums.length;i++){
            if(nums[i]==n){
                continue;
            }
            if(nums[i]==n+1 ){
              count++;
            }else {
                count=1;

            }
            ans=Math.max(ans,count);
            n=nums[i];
        }
        return ans;
    }
}
