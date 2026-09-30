class Solution {
    public int removeElement(int[] nums, int val) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        map.remove(val);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); ++i) {
                nums[count++] = entry.getKey();
            }
        }
        for (int i = count; i < nums.length; ++i) {
            nums[i] = 0;
        }
        return count;
    }
}