class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        int[] id=new int[numCourses];
        Arrays.fill(id,0);
        for(int i=0;i<prerequisites.length;i++){
            int[] temp=prerequisites[i];
            int src=temp[0];
            int dest=temp[1];
            list.get(dest).add(src);
            id[src]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<id.length;i++){
            if(id[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int n=q.poll();
            for(int z:list.get(n)){
                id[z]--;
                if(id[z]==0){
                    q.offer(z);
                }

            }
        }
        for(int i:id){
            if(i>0){
                return false;
            }
        }
        return true;
       
        
    }
}
