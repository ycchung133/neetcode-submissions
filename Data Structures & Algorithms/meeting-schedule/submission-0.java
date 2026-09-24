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
    public boolean canAttendMeetings(List<Interval> intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            if (!map.containsKey(interval.start)) {
                map.put(interval.start, interval.end);
            } else {
                return false;
            }
        }
        List<Interval> results = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();
            if (!results.isEmpty() && start < results.get(results.size() - 1).end) {
                Interval last = results.get(results.size() - 1);
                last.end = Math.max(last.end, end);
            } else {
                results.add(new Interval(start, end));
            }
        }
        return intervals.size() == results.size();
    }
}
