class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max = 0;
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);

            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            maxCount = Math.max(maxCount, count);

            while ((right - left + 1) - maxCount > k) {
                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
