class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                result[i] = 1;
                continue;
            } else {
                temp = temp * nums[i - 1];
                result[i] = temp;
            }
        }

        temp = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (i == nums.length - 1) {
                result[i] *= 1;
                continue;
            } else {
                temp = temp * nums[i + 1];
                result[i] *= temp;
            }
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
