class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());

        }
        int[] id=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int[] temp=prerequisites[i];
            int src=temp[1];
            int dst=temp[0];
            list.get(src).add(dst);
            id[dst]++;
        }
        int[] ans=new int[numCourses];
        int c=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(id[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int n=q.poll();
            ans[c]=n;
            c++;
            for(int z:list.get(n)){
                id[z]--;
                if(id[z]==0){
                    q.offer(z);
                }
            }
        }
        for(int z:id){
            if(z>0){
                return new int[]{};
            }
        }
        return ans;
    }
}
