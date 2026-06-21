class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        for (int i = 0;i < heights.length; ++i) {
            for (int j = i;j < heights.length; ++j) {
                if (i == j) {
                    continue;
                }
                int area = (Math.abs(i - j) * Math.min(heights[i], heights[j]));
                if (area > max) {
                    max = area;
                }
            }   
        }
        return max;
    }
}
