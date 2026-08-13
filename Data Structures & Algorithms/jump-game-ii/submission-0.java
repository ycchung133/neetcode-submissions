class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int end = 0;
        int farest = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            farest = Math.max(farest, i + nums[i]);
            if (i == end) {
                jumps = jumps+1;
                end = farest;
            }
        }
        return jumps;
    }
}
