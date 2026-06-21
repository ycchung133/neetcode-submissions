class Solution {
    public int lengthOfLongestSubstring(String s) {
        int L = 0, max = 0;
        HashSet<Character> set = new HashSet<>();

        for (int R = 0; R < s.length(); R++) {
            char c = s.charAt(R);
            
            while (set.contains(c) && L < R) {
                set.remove(s.charAt(L));
                L = L + 1;
            }
            
            set.add(c);
            max = Math.max(max, R - L + 1);
        }
        return max;
    }
}
