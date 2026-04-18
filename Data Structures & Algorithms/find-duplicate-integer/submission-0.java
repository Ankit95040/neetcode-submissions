class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return -1;

    }
}
