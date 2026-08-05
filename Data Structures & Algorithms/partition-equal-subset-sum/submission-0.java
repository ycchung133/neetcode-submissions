class Solution {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % 2 == 1) {
            return false;
        }
        int target = total / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return dfs(nums, 0, target, memo);
    }

    private boolean dfs(int[] nums, int i, int remaining, Boolean[][] memo) {
        if (remaining == 0) {
            return true;
        }

        if (i == nums.length) {
            return false;
        }

        if (remaining < 0) {
            return false;
        }

        if (memo[i][remaining] != null) {
            return memo[i][remaining];
        }

        memo[i][remaining] = dfs(nums, i + 1, remaining - nums[i], memo) || dfs(nums, i + 1, remaining, memo);
        return memo[i][remaining];
    }
}
