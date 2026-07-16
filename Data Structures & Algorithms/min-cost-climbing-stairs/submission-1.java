class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int[] g = new int[cost.length + 1];
        g[0] = 0;
        g[1] = 0;
        for (int i = 2; i <= cost.length; ++i) {
            g[i] = Math.min(g[i - 1] + cost[i - 1], g[i - 2] + cost[i - 2]);
        }
        return g[cost.length];
    }
}
