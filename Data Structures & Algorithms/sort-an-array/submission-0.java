class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(a,b));
        for(int i=0;i<nums.length;i++){
          pq.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=pq.poll();
        }
        return nums;
    }
}