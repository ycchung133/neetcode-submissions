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
        List<Integer> resultList = new ArrayList<>();
        for (int index = nums.length; index >= 0; --index) {
            for (int n : freq.get(index)) {
                resultList.add(n);
            }
            if (resultList.size() >= k) {
                break;
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); ++i) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
