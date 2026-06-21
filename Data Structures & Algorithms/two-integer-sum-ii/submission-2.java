class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 1;
        int p2 = 2;
        for (int i = 1; i < numbers.length * 2; ++i) {
            int sum = numbers[p1 - 1] + numbers[p2 - 1];
            if (sum < target) {
                p1 += 1;
                p2 += 1;
            } else if (sum > target) {
                p1 -= 1;
            } else {
                return new int[] {p1, p2};
            }
        }
        return null;
    }
}
