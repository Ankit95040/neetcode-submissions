class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, s, set, dp);
    }

    public boolean helper(int ind, String s, Set<String> set, Boolean[] dp) {
        if (ind == s.length()) {
            return true;
        }

        if (dp[ind] != null) {
            return dp[ind];
        }

        for (int i = ind; i < s.length(); i++) {
            String t = s.substring(ind, i + 1);

            if (set.contains(t)) {
                if (helper(i + 1, s, set, dp)) {
                    return dp[ind] = true;
                }
            }
        }

        return dp[ind] = false;
    }
}