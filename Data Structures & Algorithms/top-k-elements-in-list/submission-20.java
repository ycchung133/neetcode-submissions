class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        List<List<Integer>> freq = new ArrayList<>();
        for (int i = 0; i <= nums.length; ++i) {
            freq.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            List<Integer> list = freq.get(entry.getValue());
            list.add(entry.getKey());
        }
        int resultCount = 0;
        int[] result = new int[k];
        for (int i = nums.length; i >= 0; --i) {
            for (int n : freq.get(i)) {
                result[resultCount++] = n;
                if (resultCount >= k) {
                    break;
                }
            }
            if (resultCount >= k) {
                break;
            }
        }
        return result;
    }
}
