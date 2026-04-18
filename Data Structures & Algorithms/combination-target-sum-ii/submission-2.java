class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        helper(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    public void helper(int start,
                       int[] nums,
                       int target,
                       List<Integer> list,
                       List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {

           
            if (i > start && nums[i] == nums[i - 1])
                continue;

            
            if (nums[i] > target)
                break;

            list.add(nums[i]);

            helper(i + 1, nums, target - nums[i], list, ans);

            list.remove(list.size() - 1);
        }
    }
}