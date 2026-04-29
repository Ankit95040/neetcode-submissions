class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int t=nums[i];
            if(map.containsKey(t)){
                if(Math.abs(map.get(t)-i)<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }
}