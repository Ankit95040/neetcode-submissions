class Solution {
    public int maxScore(int[] cardPoints, int k) {
      int l=0;
      int r=cardPoints.length;
      int sum=0;
     
      for(int i=0;i<k;i++){
        sum+=cardPoints[i];
      }
     int ans=sum;
      for(int i=0;i<k;i++){
         
         sum-=cardPoints[k-i-1];
         sum+=cardPoints[r-i-1];
         ans=Math.max(sum,ans);
      }
      return ans;  
    }
}