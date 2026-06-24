class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int index = start + (end - start) / 2;
            int mid = nums[index];
            if (mid > target) {
                end = index - 1;
                continue;
            } else if (mid < target) {
                start = index + 1;
                continue;
            }
            return index;
        }

        return -1;
    }

    // public int search(int[] nums, int target) {
    //     return search(nums, target, 0, nums.length - 1);
    // }

    // public int search(int[] nums, int target, int start, int end) {
    //     if (start > end) {
    //         return -1;
    //     }
    //     int index = start + (end - start) / 2;
    //     int mid = nums[index];
    //     if (mid > target) {
    //         return search(nums, target, start, index - 1);
    //     } else if (mid < target) {
    //         return search(nums, target, index + 1, end);
    //     }
        
    //     return index;
    // }
}
