class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;
        while (left < right && right < prices.length) {
            int profit = prices[right] - prices[left];
            max = Math.max(max, profit);
            if (prices[right] < prices[left]) {
                left = right;
                right++;
            } else {
                right++;
            }
        }
        return max;
    }
}
