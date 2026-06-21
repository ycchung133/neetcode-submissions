class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            int value = prices[i];
            if (value < min) {
                min = value;
            }
            int profit = value - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
