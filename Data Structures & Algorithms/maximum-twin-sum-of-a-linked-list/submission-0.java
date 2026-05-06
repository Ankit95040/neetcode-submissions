class Solution {
    public int pairSum(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;

        while (head != null) {
            map.put(i, head.val);
            i++;
            head = head.next;
        }

        int ans = Integer.MIN_VALUE;

        for (int j = 0; j < map.size() / 2; j++) {
            ans = Math.max(ans, map.get(j) + map.get(map.size() - 1 - j));
        }

        return ans;
    }
}