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
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0; --i) {
            result.addAll(freq.get(i));
            if (result.size() >= k) {
                break;
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
