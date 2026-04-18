class Solution {
    public int maxArea(int[] heights) {
        int ans=0;
        for(int i=0;i<heights.length;i++){
            for(int j=i+1;j<heights.length;j++){
                int area=(j-i)*(Math.min(heights[i],heights[j]));
                ans=Math.max(area,ans);
            }
        }
        return ans;
    }
}
