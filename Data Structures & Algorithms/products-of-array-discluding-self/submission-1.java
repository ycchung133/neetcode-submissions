class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Scan from left to right, calculate the product of all numbers on the left of current number.
        int temp = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0) {
                temp *= nums[i - 1];
            }
            result[i] = temp;
        }


        // Scan from right to left, calculate the product of all numbers on the right of current number, then product with previous corresponding result.
        temp = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (i < nums.length - 1) {
                temp *= nums[i + 1];
            }
            result[i] *= temp;
        }

        return result;
    }


    // public int[] productExceptSelf(int[] nums) {
    //     int m = 1;
    //     int n = 1;
    //     for (int i = 0; i < nums.length; ++i) {
    //         if (nums[i] == 0) {
    //             nums[i] = 1;
    //         } else {
                
    //         }
    //         m = m * nums[i];
    //     }
    //     int[] result = new int[nums.length];
    //     for (int i = 0; i < result.length; ++i) {
    //         result[i] = m / nums[i];
    //     }
    //     return result;
        
    // }
}  
