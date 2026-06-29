class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -1 * nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            
        }

        return result;
    }

    // public List<List<Integer>> threeSum(int[] nums) {
    //     Arrays.sort(nums);
    //     List<List<Integer>> result = new ArrayList<>();
    //     for (int i = 0;i < nums.length; ++i) {
    //         if (i > 0 && nums[i] == nums[i - 1]) {
    //             continue;
    //         }
    //         int target = -1 * nums[i];
    //         int p1 = i + 1;
    //         int p2 = nums.length - 1;
    //         while (p1 < p2) {
    //             int sum = nums[p1] + nums[p2];
    //             if (sum < target) {
    //                 p1 += 1;
    //             } else if (sum > target) {
    //                 p2 -= 1;
    //             } else {
    //                 List<Integer> pr = new ArrayList<>();
    //                 pr.add(nums[i]);
    //                 pr.add(nums[p1]);
    //                 pr.add(nums[p2]);
    //                 result.add(pr);
    //                 while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
    //                 while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
    //                 p1++;
    //                 p2--;
    //             }
    //         }
    //     }
    //     return result;
    // }
}
