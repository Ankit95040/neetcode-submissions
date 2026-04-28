class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        Map<Integer,Integer> look=new HashMap<>();
        int[] ans=new int[nums1.length];
        
        for(int i=(nums2.length-1);i>=0;i--){
            while(!st.isEmpty() && st.peek()<nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                look.put(nums2[i],-1);
            }else{
                look.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);

        }
        for(int i=0;i<nums1.length;i++){
            int temp=nums1[i];
            ans[i]=look.get(temp);
        }
       return ans;
        
    }
}