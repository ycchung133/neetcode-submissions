class Solution {

    HashMap<Integer, Integer> notes = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int result = dfs(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int[] coins, int remaining) {
        if (remaining == 0) {
            return 0;
        }
        if (remaining < 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int result;
            if (notes.containsKey(remaining - c)) {
                result = notes.get(remaining - c);
            } else {
                result = dfs(coins, remaining - c);
                notes.put(remaining - c, result);
            }
            if (result != Integer.MAX_VALUE) {
                min = Math.min(min, result + 1);
            }
        }
        return min;
    }
}
