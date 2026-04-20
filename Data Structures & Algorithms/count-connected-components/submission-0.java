class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int[] temp=edges[i];
            int src=temp[0];
            int dest=temp[1];
            list.get(src).add(dest);
            list.get(dest).add(src);
        }
        int[] vis=new int[n];
        int ans=0;
        for(int i=0;i<n;i++ ){
            if(vis[i]==0){
                dfs(i,vis,list);
                ans++;
            }
            
        }
        return ans;
    }
    public void dfs(int i,int[] vis,List<List<Integer>> list){
        vis[i]=1;
        for(int n:list.get(i)){
            if(vis[n]==0){
                dfs(n,vis,list);
            }
        }
    }
}
