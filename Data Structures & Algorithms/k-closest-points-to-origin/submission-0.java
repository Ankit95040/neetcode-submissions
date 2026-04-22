class Pair{
    int ind;
    double dis;
    public Pair(int ind,double dis){
        this.ind=ind;
        this.dis=dis;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(a.dis,b.dis));
        for(int i=0;i<points.length;i++){
            int[] temp=points[i];
            int f=temp[0];
            int s=temp[1];
            double distance=Math.sqrt(f*f+s*s);
            pq.add(new Pair(i,distance));
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            Pair p=pq.poll();
            int in=p.ind;
            ans[i]=points[in];
        }
        return ans;

    }
}
