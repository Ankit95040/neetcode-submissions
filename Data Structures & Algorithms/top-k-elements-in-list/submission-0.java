class Pair{
    int ele;
    int fr;
    public Pair(int ele,int fr){
        this.ele=ele;
        this.fr=fr;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.fr-a.fr);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int ele=entry.getKey();
            int fr=entry.getValue();
            pq.add(new Pair(ele,fr));
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            Pair temp=pq.poll();
            int el=temp.ele;
            ans[i]=el;

        }
        return ans;
    }
}
