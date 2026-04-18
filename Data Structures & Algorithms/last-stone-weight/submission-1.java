class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int n:stones){
            pq.add(n);
        }
        while(pq.size()>1){
          int temp= pq.poll()-pq.poll();
          pq.add(temp);

        }
        return pq.poll();
       }
    }
  