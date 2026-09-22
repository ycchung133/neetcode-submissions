class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        while (!map.isEmpty()) {
            int smallest = map.firstKey();
            for (int i = 0; i < groupSize; ++i) {
                int need = smallest + i;
                if (!map.containsKey(need)) {
                    return false;
                }
                int newCount = map.get(need) - 1;
                if (newCount == 0) {
                    map.remove(need);
                } else {
                    map.put(need, newCount);
                }
            }
        }
        return true;
    }
}
