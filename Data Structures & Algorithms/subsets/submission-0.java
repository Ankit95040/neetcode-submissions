class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        helper(0,ans,list,nums);
        return ans;
    }
    public void helper(int ind,List<List<Integer>> ans,List<Integer> list,int[] nums){
        if(ind==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        helper(ind+1,ans,list,nums);
        list.remove(list.size()-1);
        helper(ind+1,ans,list,nums);
    }
}
