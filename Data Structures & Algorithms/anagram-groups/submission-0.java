

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if (visited[i])
                continue;

            List<String> list = new ArrayList<>();

            int[] arr1 = new int[26];

            for (char c : strs[i].toCharArray()) {
                arr1[c - 'a']++;
            }

            list.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {

                if (visited[j])
                    continue;

                int[] arr2 = new int[26];

                for (char c : strs[j].toCharArray()) {
                    arr2[c - 'a']++;
                }

                if (Arrays.equals(arr1, arr2)) {

                    list.add(strs[j]);
                    visited[j] = true;

                }
            }

            ans.add(list);
        }

        return ans;
    }
}