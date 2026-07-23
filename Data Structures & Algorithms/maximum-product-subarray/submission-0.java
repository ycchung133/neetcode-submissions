class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            int n = nums[i];
            int newMax = Math.max(n, Math.max(n * currentMax, n * currentMin));
            int newMin = Math.min(n, Math.min(n * currentMax, n * currentMin));
            currentMax = newMax;
            currentMin = newMin;
            result = Math.max(result, currentMax);
        }

        return result;
    }
}
