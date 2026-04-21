class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;

        // Step 1: Check global feasibility
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }

        if (sum < 0) {
            return -1;
        }

        int tank = 0;
        int start = 0;

        // Step 2: Find valid start
        for (int i = 0; i < gas.length; i++) {

            tank += gas[i] - cost[i];

            if (tank < 0) {
                tank = 0;
                start = i + 1;   // FIX
            }
        }

        return start;
    }
}