class Solution {


    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // public int lengthOfLongestSubstring(String s) {
    //     int L = 0, max = 0;
    //     HashSet<Character> set = new HashSet<>();

    //     for (int R = 0; R < s.length(); R++) {
    //         char c = s.charAt(R);
            
    //         while (set.contains(c) && L < R) {
    //             set.remove(s.charAt(L));
    //             L = L + 1;
    //         }
            
    //         set.add(c);
    //         max = Math.max(max, R - L + 1);
    //     }
    //     return max;
    // }
}
