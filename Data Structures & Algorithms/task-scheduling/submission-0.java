class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (char c : tasks) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            maxFreq = Math.max(maxFreq, count);
        }

        int maxCount = 0;
        for (char c : map.keySet()) {
            if (map.get(c) == maxFreq) {
                maxCount++;
            }
        }

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}
