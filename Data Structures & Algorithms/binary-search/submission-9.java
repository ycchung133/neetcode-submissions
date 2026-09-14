class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = start + (end - start) / 2;
            int mid = nums[index];
            if (mid < target) {
                start = index + 1;
                continue;
            } else if (mid > target) {
                end = index - 1;
                continue;
            } else {
                return index;
            }
        }
        return -1;
    }
}
