class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                continue;
            }
            set.remove(num);
            int left = num - 1;
            int right = num + 1;
            while (set.remove(left)) {
                left--;
            }
            while (set.remove(right)) {
                right++;
            }
            longest = Math.max(longest, right - left - 1);
        }
        return longest;
    }

    // public int longestConsecutive(int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     }
    //     if (nums.length == 1) {
    //          return 1;
    //     }
    //     Arrays.sort(nums);
    //     int max = 1;
    //     int count = 1;
    //     for (int i = 1;i < nums.length; ++i) {
    //         if (nums[i] - 1 == nums[i - 1]) {
    //             count += 1;
    //         } else if (nums[i] == nums[i - 1]) {
    //         } else {
    //             count = 1;
    //         }
    //         if (count > max) {
    //             max = count;
    //         }
    //     }
    //     return max;

    // }
}
