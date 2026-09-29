class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            char charToAdd = s.charAt(right);
            while (set.contains(charToAdd)) {
                char charToRemove = s.charAt(left);
                set.remove(charToRemove);
                left++;
            }
            set.add(charToAdd);
            right++;
            max = Math.max(right - left, max);
        }
        return max;
    }
}
