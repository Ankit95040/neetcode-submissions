class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        helper(0,nums,target,list,ans);
        return ans;
    }
    public void helper(int ind,int[] nums,int target,  List<Integer> list,   List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0){
            return;
        }
        if(ind>=nums.length){
            return;
        }
        list.add(nums[ind]);
        helper(ind,nums,target-nums[ind],list,ans);
        list.remove(list.size()-1);
        helper(ind+1,nums,target,list,ans);
    }
}
