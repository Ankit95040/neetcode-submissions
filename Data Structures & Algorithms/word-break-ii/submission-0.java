class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);

        helper(0, list, s, set);

        return ans;
    }

    public void helper(int ind, List<String> list, String s, Set<String> set) {
        if (ind == s.length()) {
            ans.add(String.join(" ", list));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            String temp = s.substring(ind, i + 1);

            if (set.contains(temp)) {
                list.add(temp);

                helper(i + 1, list, s, set);

                list.remove(list.size() - 1);
            }
        }
    }
}