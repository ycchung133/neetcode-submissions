class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0;i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (i != j && (nums[j] + nums[i]) == target) {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }
}
