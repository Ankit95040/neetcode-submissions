class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = 0;

        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            int freq=entry.getValue();
            if (freq == 1) {
                return -1;
            }

            ans += freq / 3;

            if (freq % 3 != 0) {
                ans++;
            }
        }

        return ans;
    }
}