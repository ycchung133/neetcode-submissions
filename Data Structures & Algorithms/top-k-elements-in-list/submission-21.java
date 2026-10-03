class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        List<List<Integer>> freq = new ArrayList<>();
        for (int i = 0; i <= nums.length; ++i) {
            freq.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            List<Integer> list = freq.get(entry.getValue());
            list.add(entry.getKey());
        }
        int count = 0;
        int[] results = new int[k];
        for (int i = nums.length; i >= 0; --i) {
            for (int n : freq.get(i)) {
                results[count++] = n;
                if (count >= k) {
                    break;
                }
            }
            if (count >= k) {
                break;
            }
        }
        return results;
    }
}
