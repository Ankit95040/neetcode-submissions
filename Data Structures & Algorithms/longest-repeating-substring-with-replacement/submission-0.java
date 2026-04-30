class Solution {
    public int characterReplacement(String s, int k) {
        int maxl=0;
        int maxf=0;
        int l=0;
        int[] freq=new int[26];
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            freq[c-'A']++;
            maxf=Math.max(maxf,freq[c-'A']);
            while((r-l+1)-maxf>k){
                char a=s.charAt(l);
                freq[a-'A']--;
                l++;
            }
            maxl=Math.max(r-l+1,maxl);

        }
        return maxl;
    }
}
