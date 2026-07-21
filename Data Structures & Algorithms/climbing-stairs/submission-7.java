class Solution {

    public int climbStairs(int n) {

        int[] ways = new int[Math.max(3, n + 1)];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        if (n <= 2) {
            return ways[n];
        }
        for (int i = 3; i <= n; ++i) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }
    
    // Map<Integer, Integer> map = new HashMap<>();


    // public int climbStairs(int n) {
    //     if (n == 0) {
    //         return 1;
    //     }
    //     if (n < 0) {
    //         return 0;
    //     }
    //     if (map.containsKey(n)) {
    //         return map.get(n);
    //     }
    //     int result = climbStairs(n - 1) + climbStairs(n - 2);
    //     map.put(n, result);
    //     return result;
    // }
}
