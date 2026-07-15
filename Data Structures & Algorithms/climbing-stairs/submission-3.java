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
        int result1 = climbStairs(n - 1);
        if (!map.containsKey(n - 1)) {
            map.put(n - 1, result1);
        }
        int reuslt2 = climbStairs(n - 2);
        if (!map.containsKey(n - 2)) {
            map.put(n - 2, result1);
        }
        return result1 + reuslt2;
    }
}
