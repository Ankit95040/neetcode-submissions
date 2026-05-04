class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int l=0;
        int r=k-1;
        int count=0;
        while(r<arr.length){
            int avg=0;
            for(int i=l;i<=r;i++){
               avg+=arr[i];
            }
            if((avg/k)>=threshold ){
                count++;
            }
            l++;
            r++;
        }
        return count;
    }
}