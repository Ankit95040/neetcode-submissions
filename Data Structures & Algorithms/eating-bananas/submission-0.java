class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = 0;

        
        for (int n : piles) {
            r = Math.max(r, n);
        }

        int ans = r;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            int hours = helper(mid, piles);

            if (hours > h) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }

        return ans;
    }

    public int helper(int speed, int[] piles) {

        int totalHours = 0;

        for (int bananas : piles) {

           
            totalHours += (bananas + speed - 1) / speed;
        }

        return totalHours;
    }
}