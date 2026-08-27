class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int top = 0;
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            int times = map.get(i) + 1;
            map.put(i, times);
            if (top < times) {
                top = times;
            }
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = entries.get(i).getKey();
        }
        return result;
    }

}
