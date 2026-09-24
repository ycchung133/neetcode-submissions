class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = 0;
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        while (index < n && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);
            index++;
        }
        while (index < n && !(intervals[index][0] > newInterval[1])) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        result.add(newInterval);

        while (index < n) {
            result.add(intervals[index]);
            index++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
