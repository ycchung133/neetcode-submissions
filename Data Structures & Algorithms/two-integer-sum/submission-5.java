class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];
            if (m.containsKey(complement)) {
                return new int[]{m.get(complement), i};
            }
            m.put(nums[i], i);
        }

        return null;
    }

    // public int[] twoSum(int[] nums, int target) {
    //     int L = 0;
    //     int R = nums.length - 1;
    //     while (L < R) {
    //         int sum = nums[L] + nums[R];
    //         if (sum < target) {
    //             L += 1;
    //         } else if (sum > target) {
    //             R -= 1;
    //         } else {
    //             return new int[]{L, R};
    //         }
    //     }
    //     return null;
    // }

    // public int[] twoSum(int[] nums, int target) {
    //     ArrayList<int[]> result = new ArrayList<>();
    //     for (int i = 0;i < nums.length; ++i) {
    //         for (int j = 0; j < i; ++j) {
    //             if (i != j && (nums[j] + nums[i]) == target) {
    //                 return new int[]{j, i};
    //             }
    //         }
    //     }
    //     return null;
    // }
}
