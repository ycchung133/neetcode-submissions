class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = copy(nums, 0, mid - 1);
        int[] right = copy(nums, mid, nums.length - 1);
        left = sortArray(left);
        right = sortArray(right);
        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        int leftCount = 0;
        int rightCount = 0;
        int count = 0;
        int[] output = new int[left.length + right.length];
        while (leftCount < left.length || rightCount < right.length) {
            int next;
            if (leftCount < left.length && rightCount < right.length) {
                if (left[leftCount] < right[rightCount]) {
                    next = left[leftCount++];
                } else {
                    next = right[rightCount++];
                }
            } else if (leftCount < left.length) {
                next = left[leftCount++];
            } else {
                next = right[rightCount++];
            }
            output[count++] = next;
        }
        return output;
    }

    public int[] copy(int[] input, int start, int end) {
        int[] output = new int[end - start + 1];
        for (int i = start; i <= end; ++i) {
            output[i - start] = input[i];
        }
        return output;
    }
}