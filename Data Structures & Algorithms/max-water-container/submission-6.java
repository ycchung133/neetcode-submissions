class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left < right) {
            int area = (right - left) * Math.min(heights[right], heights[left]);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, area);
        }
        return max;
    }
}
