class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while ((right - left + 1) - k > Collections.max(map.values())) {
                char charToRemove = s.charAt(left);
                map.put(charToRemove, map.get(charToRemove) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
