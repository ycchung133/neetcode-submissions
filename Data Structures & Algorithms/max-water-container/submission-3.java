class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int r = heights.length - 1;
        int l = 0;
        while (l < r) {
            int area = (r - l) * Math.min(heights[r], heights[l]);
            if (area > max) {
                max = area;
            }
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
