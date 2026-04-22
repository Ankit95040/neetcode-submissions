class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int first = intervals[0][0];
        int last = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int[] curr = intervals[i];
            int start = curr[0];
            int end = curr[1];

            // overlap
            if (start <= last) {
                last = Math.max(last, end);
            } 
            // no overlap
            else {
                result.add(new int[]{first, last});
                first = start;
                last = end;
            }
        }

        
        result.add(new int[]{first, last});

        return result.toArray(new int[result.size()][]);
    }
}