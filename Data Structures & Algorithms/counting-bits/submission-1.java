class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int last = 1;
        int d = 1;
        for (int i = 0; i <= n; i++) {
            if (i == last * 2) {
                last = i;
                d = d * 2;
            }
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - d] + 1;
            }
        }
        return dp;
    }
}
