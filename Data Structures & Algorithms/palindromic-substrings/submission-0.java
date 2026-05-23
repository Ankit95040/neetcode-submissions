class Solution {
    int count = 0;

    public int countSubstrings(String s) {
        helper(0, s);
        return count;
    }

    public void helper(int ind, String s) {
        if (ind == s.length()) {
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            String t = s.substring(ind, i + 1);

            if (isPali(t)) {
                count++;
            }
        }

        helper(ind + 1, s);
    }

    public boolean isPali(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}