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

    // public int[] topKFrequent(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     HashMap<Integer, Integer> h = new HashMap<>();
    //     for (int i : nums) {
    //         if (!h.containsKey(i)) {
    //             h.put(i, 0);
    //         }
    //         h.put(i, h.get(i) + 1);
    //     }
        
    //     List<Integer> output = new ArrayList();
    //     for (int i = 0; i < k; ++i) {
    //         int max = 0;
    //         int num = -1;
    //         for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
    //             if (entry.getValue() > max) {
    //                 max = entry.getValue();
    //                 num = entry.getKey();
    //             }
    //         }
    //         output.add(num);
    //         h.remove(num);
    //     }
    //     return output.stream().mapToInt(Integer::intValue).toArray();
    // }
}
