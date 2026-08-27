class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            int max = 0;
            int index = 0;
            int key = -1;
            for (int j = 0; j < list.size(); ++j) {
                int times = list.get(j).getValue();
                if (max < times) {
                    max = times;
                    index = j;
                    key = list.get(j).getKey();
                }
            }
            temp.add(key);
            list.remove(index);

        }
        int result[] = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = temp.get(i);
        }
        return result;
    }
}
