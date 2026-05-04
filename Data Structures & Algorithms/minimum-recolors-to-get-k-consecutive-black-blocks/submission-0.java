class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0, r = 0;
        int count = 0;
        int ans = Integer.MAX_VALUE;

        while (r < blocks.length()) {

            if (blocks.charAt(r) == 'W') {
                count++;
            }

           
            if (r - l + 1 > k) {
                if (blocks.charAt(l) == 'W') {
                    count--;
                }
                l++; 
            }

            
            if (r - l + 1 == k) {
                ans = Math.min(ans, count);
            }

            r++;
        }

        return ans;
    }
}