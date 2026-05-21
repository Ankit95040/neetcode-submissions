

class Solution {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return helper(0, s, dp);
    }

    public int helper(int ind, String s, int[] dp) {
        if (ind >= s.length()) {
            return 1;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        if (s.charAt(ind) == '0') {
            return 0;
        }

        int one = helper(ind + 1, s, dp);

        int two = 0;

        if (ind + 1 < s.length()) {
            int t = Integer.parseInt(s.substring(ind, ind + 2));

            if (t >= 10 && t <= 26) {
                two = helper(ind + 2, s, dp);
            }
        }

        return dp[ind] = one + two;
    }
}