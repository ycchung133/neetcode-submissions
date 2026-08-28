class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int longest = 0;
        for (int n : nums) {
            if (!set.contains(n)) {
                continue;
            }
            set.remove(n);
            int left = n - 1;
            int right = n + 1;
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
}
