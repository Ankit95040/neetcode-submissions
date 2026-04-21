class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                st1.push(i);
            }
            if(c=='*'){
                st2.push(i);
               
            }
            if(c==')'){
                if(!st1.isEmpty()){
                    st1.pop();
                }else if(!st2.isEmpty()){
                    st2.pop();
                }else return false;

            }

        }
        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st2.peek()<st1.peek()){
                return false;
            }
            st1.pop();
            st2.pop();
        }
        return st1.isEmpty();
    }
}
