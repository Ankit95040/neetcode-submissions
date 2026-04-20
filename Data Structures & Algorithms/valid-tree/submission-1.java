class Pair{
    int parent;
    int node;
    public Pair(int parent,int node){
        this.parent=parent;
        this.node=node;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
      List<List<Integer>> list=new ArrayList<>();
      for(int i=0;i<n;i++){
        list.add(new ArrayList<>());
      }
      Queue<Pair> q=new LinkedList<>();
      for(int i=0;i<edges.length;i++){
        int[] ed=edges[i];
        int src=ed[0];
        int dst=ed[1];
        list.get(src).add(dst);
        list.get(dst).add(src);
      }
      int[] vis=new int[n];
      q.offer(new Pair(-1,0));
      while(!q.isEmpty()){
        Pair p=q.poll();
        int par=p.parent;
        int nod=p.node;
        vis[nod]=1;
        for(int z:list.get(nod)){
            if(z!=par && vis[z]==1){
                return false;
            }else if(vis[z]!=1){ 
                 q.offer(new Pair(nod,z));
            }else continue;
           
        }
      }
      for(int d:vis){
        if(d!=1){
            return false;
        }
      }
      return true;

    }
    
}
