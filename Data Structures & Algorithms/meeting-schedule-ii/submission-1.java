/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        ArrayList<Integer> starts = new ArrayList<>();
        ArrayList<Integer> ends = new ArrayList<>();
        for (Interval interval : intervals) {
            starts.add(interval.start);
            ends.add(interval.end);
        }
        starts.sort(null);
        ends.sort(null);
        int overlaps = 0;
        int max = 0;
        while (!starts.isEmpty() || !ends.isEmpty()) {
            boolean removeFromStarts = false;
            if (!starts.isEmpty() && !ends.isEmpty()) {
                removeFromStarts = starts.get(0) < ends.get(0);
            } else if (ends.isEmpty()) {
                removeFromStarts = true;
            }
            if (removeFromStarts) {
                starts.remove(0);
                overlaps++;
            } else {
                ends.remove(0);
                overlaps--;
            }
            max = Math.max(max, overlaps);
        }
        return max;
    }
}
