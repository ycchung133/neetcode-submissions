class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int rotate = left;
        int length = nums.length;
        
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int convertedMid = (mid + rotate) % length;
            
            if (nums[convertedMid] > target) {
                right = mid - 1;
            } else if (nums[convertedMid] < target) {
                left = mid + 1;
            } else {
                return convertedMid;
            }

        }

        return -1;
    }
}
