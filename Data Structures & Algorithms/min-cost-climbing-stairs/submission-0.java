class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] g = new int[n + 1];
        g[0] = 0;
        g[1] = 0;
        for (int i = 2; i <= n; ++i) {
            g[i] = Math.min(g[i - 1] + cost[i - 1], g[i - 2] + cost[i - 2]);
        }
        return g[n];
    }
}
