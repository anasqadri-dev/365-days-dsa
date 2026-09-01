class Day236 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int removals = 0;
        int previousEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < previousEnd) {
                removals++;
            } else {
                previousEnd = intervals[i][1];
            }
        }
        return removals;
    }
}