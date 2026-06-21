class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i : nums) {
            if (!h.containsKey(i)) {
                h.put(i, 0);
            }
            h.put(i, h.get(i) + 1);
        }
        
        List<Integer> output = new ArrayList();
        for (int i = 0; i < k; ++i) {
            int max = 0;
            int num = -1;
            for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    num = entry.getKey();
                }
            }
            output.add(num);
            h.remove(num);
        }
        int[] outputArray = new int[output.size()];
        for (int i = 0; i < outputArray.length; ++i) {
            outputArray[i] = output.get(i);
        }
        return outputArray;
    }
}
