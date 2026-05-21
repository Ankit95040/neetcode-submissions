class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        helper(0, list, ans, s);

        return ans;
    }

    public void helper(int ind, List<String> list, List<List<String>> ans, String s) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            String t = s.substring(ind, i + 1);

            if (pali(t)) {
                list.add(t);

                helper(i + 1, list, ans, s);

                list.remove(list.size() - 1);   
            }
        }
    }

    public boolean pali(String t) {
        for (int i = 0; i < t.length() / 2; i++) {
            if (t.charAt(i) != t.charAt(t.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}