class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int m=0;
        int r=nums.length-1;
        while(m<=r){
            int temp=nums[m];
            if(temp==0){
              int zero=nums[m];
              nums[m]=nums[l];
              nums[l]=zero;
              l++;
              m++;
            }else if(temp==1){
                m++;
            }else{
                int two=nums[m];
                nums[m]=nums[r];
                nums[r]=two;
                r--;
            }
        }
    }
}