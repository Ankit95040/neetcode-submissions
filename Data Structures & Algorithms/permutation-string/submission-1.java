class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            if (i + s1.length() > s2.length()) break;

            Map<Character, Integer> copy = new HashMap<>(map);

            for (int j = i; j < i + s1.length(); j++) {
                char temp = s2.charAt(j);

                if (copy.getOrDefault(temp, 0) > 0) {
                    copy.put(temp, copy.get(temp) - 1);

                    if (copy.get(temp) == 0) {
                        copy.remove(temp);
                    }
                } else {
                    break;
                }
            }

            if (copy.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}