class Solution {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int price:prices){
            min = Math.min(min, price);
            profit = Math.max(profit,price - min);
        }
        return profit;
    }
    
    // public int maxProfit(int[] prices) {
    //     int min = Integer.MAX_VALUE;
    //     int profit = 0;
    //     for (int i = 0; i < prices.length; ++i) {
    //         if (prices[i] < min) {
    //             min = prices[i];
    //         }
    //         profit = Math.max(profit, prices[i] - min);
    //     }
    //     return profit;
    // }

    // public int maxProfit(int[] prices) {
    //     int min = Integer.MAX_VALUE;
    //     int maxProfit = 0;
    //     for (int i = 0; i < prices.length; ++i) {
    //         int value = prices[i];
    //         if (value < min) {
    //             min = value;
    //         }
    //         int profit = value - min;
    //         if (profit > maxProfit) {
    //             maxProfit = profit;
    //         }
    //     }
    //     return maxProfit;
    // }
}
