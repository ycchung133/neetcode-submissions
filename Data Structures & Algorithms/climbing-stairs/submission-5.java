class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        if (!map.containsKey(n)) {
            map.put(n, result);
        }
        return result;
    }
}
