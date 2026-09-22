class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int n : hand) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        while (!count.isEmpty()) {
            int head = count.firstKey();
            for (int i = 0; i < groupSize; ++i) {
                int newCount = count.getOrDefault(head + i, 0) - 1;
                if (newCount < 0) {
                    return false;
                }
                if (newCount == 0) {
                    count.remove(head + i);
                } else {
                    count.put(head + i, newCount);
                }
            }
        }
        return true;
    }
}
