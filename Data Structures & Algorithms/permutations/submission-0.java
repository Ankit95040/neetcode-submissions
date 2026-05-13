class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtrack(0,list,ans,nums);
        return ans;
    }
    public void backtrack(int ind,List<Integer> list,List<List<Integer>> ans,int[] nums){
        if (ind == nums.length) {
            List<Integer> temp = new ArrayList<>();

            for (int num : nums) {
                temp.add(num);
            }

            ans.add(temp);
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(ind,i,nums);
            backtrack(ind+1,list,ans,nums);
            swap(ind,i,nums);
        }
    }
    public void swap(int a,int b,int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
