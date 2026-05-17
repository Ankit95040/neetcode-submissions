class Solution {
    public boolean hasDuplicate(int[] nums) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
            ans=map.get(n);
            if(ans==2){
                return true;
            }
        }
        return false;
        
    }
}