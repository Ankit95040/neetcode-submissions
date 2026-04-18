class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r=0;
        int l=0;
       
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        while(r<s.length()){
            char c=s.charAt(r);
           
            if(map.containsKey(c)){
               l=Math.max(l,map.get(c)+1);
            }
            map.put(c,r);
            ans=Math.max(ans,r-l+1);
            r++;
            

        }
        return ans;
    }
}
