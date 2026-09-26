class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                temp[i] = 1;
            } else {
                temp[i] = temp[i - 1] * nums[i - 1];
            }
        }
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (i == nums.length - 1) {
                result[i] = 1;
            } else {
                result[i] = result[i + 1] * nums[i + 1];
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            result[i] = result[i] * temp[i];
        }
        return result;
    }
}  
