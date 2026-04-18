class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int n:nums){
            pq.add(n);
        }
        int ans=-1;
        for(int i=0;i<k;i++){
            ans=pq.poll();

        }
        return ans;
    }
}
