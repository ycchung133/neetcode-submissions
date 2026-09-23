class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        int carry = 0;
        do {
            result = a ^ b;
            carry = (a & b) << 1;
            if (carry != 0) {
                a = result;
                b = carry;
            }
        } while (carry != 0);
        return result;
    }
}
