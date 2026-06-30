class Solution {
    
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max = 0;
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > maxCount) {
                maxCount = map.get(c);
            }

            while ((right - left + 1) - maxCount > k) {
                char charToRemove = s.charAt(left);
                map.put(charToRemove, map.get(charToRemove) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
    
    // public int characterReplacement(String s, int k) {
    //     int L = 0, max = 0, maxCount = 0;
    //     int[] count = new int[26];

    //     for (int R = 0; R < s.length(); R++) {
    //         char c = s.charAt(R);

    //         // 加入 s[R]，更新 count 和 maxCount
    //         count[c - 'A']++;
    //         if (count[c - 'A'] > maxCount) {
    //             maxCount = count[c - 'A'];
    //         }
            
    //         // 如果窗口不合法...
    //         //   移動 L
    //         while ((R - L + 1) - maxCount > k) {
    //             count[s.charAt(L) - 'A']--;
    //             L++;
    //         }

    //         // 更新 max
    //         max = Math.max(max, R - L + 1);

    //     }
    //     return max;
    // }
}
