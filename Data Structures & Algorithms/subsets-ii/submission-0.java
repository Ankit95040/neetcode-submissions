class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set =new HashSet<>();
        List<Integer> list=new ArrayList<>();
        helper(0,set,list,nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(List<Integer> ele:set){
            ans.add(ele);
        }
        return ans;
    }
   public void helper(int ind,   Set<List<Integer>> set,  List<Integer> list,int[] nums){
        if(ind==nums.length){
            set.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        helper(ind+1,set,list,nums);
        list.remove(list.size()-1);
        helper(ind+1,set,list,nums);
    }
}
