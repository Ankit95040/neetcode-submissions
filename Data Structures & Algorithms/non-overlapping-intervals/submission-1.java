class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int last = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int first = intervals[i][0];
            int second = intervals[i][1];

            // overlap
            //we dont update last as we completely omit that interval
            if (first < last) {
                count++;
            } 
            // no overlap
            else {
                last = second;
            }
        }

        return count;
    }
}