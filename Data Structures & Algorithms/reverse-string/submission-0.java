class Solution {
    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
             char start=s[i];
             char end=s[s.length-1-i];
             s[i]=end;
             s[s.length-1-i]=start;

        }
    }
}