class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return true;
        }

       
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        
        Interval first = intervals.get(0);
        int last = first.end;

       
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);

            if (temp.start < last) {
                return false; 
            }

            last = temp.end;
        }

        return true;
    }
}