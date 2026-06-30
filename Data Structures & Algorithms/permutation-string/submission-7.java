class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            need[s1.charAt(i) - 'a']++;
        }

        for (int right = 0; right < s2.length(); ++right) {
            char c = s2.charAt(right);
            window[c - 'a']++;

            if ((right - left + 1) > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            if ((right - left + 1) == s1.length()) {
                boolean result = true;
                for (int i = 0; i < 26; ++i) {
                    if (need[i] != window[i]) {
                        result = false;
                        break;
                    }
                }
                if (result) {
                    return true;
                }
            }
        }

        return false;

    }


    // public boolean checkInclusion(String s1, String s2) {
    //     HashSet<Character> set = new HashSet<>();
    //     HashMap<Character, Integer> window = new HashMap<>();
    //     for (char c : s1.toCharArray()) {
    //         set.add(c);
    //         window.put(c, window.getOrDefault(c, 0) + 1);
    //     }
    //     int nonZero = window.size();
    //     for (int i = 0;i < s2.length();++i) {
    //         char c = s2.charAt(i);

    //         //
    //         if (i >= s1.length()) {
    //             char d = s2.charAt(i - s1.length());
    //             if (set.contains(d)) {
    //                 int count = window.containsKey(d) ? window.get(d) : 0;
    //                 int newCount = window.containsKey(d) ? window.get(d) + 1 : 1;
    //                 window.put(d, newCount);
    //                 if (count == 0 && newCount != 0) {
    //                     nonZero += 1;
    //                 }
    //                 if (count != 0 && newCount == 0) {
    //                     nonZero -= 1;
    //                 }
    //             }
    //         }
            
    //         //
    //         if (window.containsKey(c)) {
    //             int count = window.get(c);
    //             int newCount = window.get(c) - 1;
    //             window.put(c, newCount);
    //             if (count == 0 && newCount != 0) {
    //                 nonZero += 1;
    //             }
    //             if (count != 0 && newCount == 0) {
    //                 nonZero -= 1;
    //             }
    //         }

    //         // boolean pass = true;
    //         // for (int j : window.values()) {
    //         //     if (j != 0) {
    //         //         pass = false;
    //         //     }
    //         // }
    //         // if (pass) {
    //         //     return true;
    //         // }
    //         if (nonZero == 0) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
