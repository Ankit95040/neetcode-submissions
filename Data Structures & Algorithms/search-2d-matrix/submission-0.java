class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean ans=false;
        for(int i=0;i<n;i++){
            if(target>=matrix[i][0] && target<=matrix[i][m-1]){
                ans= helper(matrix[i],target);
            }
        }
        return ans;
    }
    public boolean helper(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while(r>=l){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]>target){
              r=mid-1;
            }else l=mid+1;
        }
        return false;
    }
}
