class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }   
        int min = left;   
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int rotated = (mid + min) % nums.length;
            if (nums[rotated] < target) {
                left = mid + 1;
            } else if (nums[rotated] > target) {
                right = mid - 1;
            } else {
                return rotated;
            }
        }
        return -1;
    }
}
