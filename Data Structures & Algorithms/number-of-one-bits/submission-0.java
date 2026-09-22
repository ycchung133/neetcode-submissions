class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        do {
            if (n % 2 == 1) {
                count++;
            }
            n = n / 2;
        } while (n >= 1);
        return count;
    }
}
