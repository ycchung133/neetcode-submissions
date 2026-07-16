class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] g = new int[nums.length];
        g[0] = nums[0];
        g[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            g[i] = Math.max(g[i - 1], g[i - 2] + nums[i]);
        }
        return g[nums.length - 1];
    }
}
