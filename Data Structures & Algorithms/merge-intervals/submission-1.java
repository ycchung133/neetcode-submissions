class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], Math.max(interval[1], map.getOrDefault(interval[0], 0)));
        }
        List<int[]> results = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();
            if (!results.isEmpty() && start <= results.get(results.size() - 1)[1]) {
                int last[] = results.get(results.size() - 1);
                last[1] = Math.max(last[1], end);
            } else {
                results.add(new int[] {start, end});
            }
        }
        return results.toArray(new int[results.size()][]);
    }
}
