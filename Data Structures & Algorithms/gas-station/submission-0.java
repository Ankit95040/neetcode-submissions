class Pair{
    int g;
    int c;
    public Pair(int g,int c){
        this.g=g;
        this.c=c;
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int max=gas.length;
       for(int j=0;j<gas.length;j++){
        int sum=0;
        int count=0;

       for(int i=0;i<max;i++){
           int ind=(i+j)%max;
           sum+=gas[ind]-cost[ind];
           if(sum<0){
            break;
           }
           count++;

       }
       if(count==max){
        return j;
       }
       }
       return -1;
    }
}
