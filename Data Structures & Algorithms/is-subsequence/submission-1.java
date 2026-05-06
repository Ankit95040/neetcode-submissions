class Solution {
    public boolean isSubsequence(String s, String t) {
        int l=0;
        int r=0;
        while(r<t.length()){
            if(l>=s.length()-1){
                return true;
            }
            if(s.charAt(l)==t.charAt(r)){
                l++;
                r++;
            }else{
                r++;
            }
        }
        return false;
    }
}