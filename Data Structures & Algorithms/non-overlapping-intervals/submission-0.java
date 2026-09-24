class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int lastEnd = intervals[0][1];
        int removeCount = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < lastEnd) {
                removeCount++;
            } else {
                lastEnd = intervals[i][1];
            }
        }
        return removeCount;
    }
}
