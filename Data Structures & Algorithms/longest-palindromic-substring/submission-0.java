class Solution {
     String ans="";
    public String longestPalindrome(String s) {
        helper(0,s);
        return ans;
    }
    public void helper(int ind,String s){
        if(ind==s.length()){
            return;
        }
        for(int i=ind;i<s.length();i++){
            String t=s.substring(ind,i+1);
            if(isPali(t)){
                if(t.length()>ans.length()){
                    ans=t;
                }
            }
        }
        helper(ind+1,s);
    }
    public boolean isPali(String s){
        int l=0;
        int r=s.length()-1;
        while(r>l){
            if(s.charAt(r)!=s.charAt(l)){
                return false;
            }
            r--;
            l++;
        }
        return true;
    }
}
