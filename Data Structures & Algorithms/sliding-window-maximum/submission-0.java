class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0;
        int r=k-1;
        List<Integer> list=new ArrayList<>();
        
        while(r<nums.length){
            int max=-(int)1e9;
            for(int i=l;i<=r;i++){
                max=Math.max(max,nums[i]);

            }
            list.add(max);
            r++;
            l++;

        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
