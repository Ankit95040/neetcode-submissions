class Solution {
    public int appendCharacters(String s, String t) {
        int l=0;
        int r=0;
        while(r<s.length()){
              if(l>t.length()-1){
                return 0;
            }
             if(s.charAt(r)==t.charAt(l)){
                l++;
                r++;
                
             }else{
                r++;
             }
             
        }
        return t.length()-l;
    }
}