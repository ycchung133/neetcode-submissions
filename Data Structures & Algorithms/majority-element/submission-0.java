class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = 0;
        int value = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int times = entry.getValue();
            if (max < times) {
                max = times;
                value = entry.getKey();
            }
        }
        return value;
    }
}