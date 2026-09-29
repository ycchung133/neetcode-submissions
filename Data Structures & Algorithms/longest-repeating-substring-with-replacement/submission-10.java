class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char charToAdd = s.charAt(right);
            map.put(charToAdd, map.getOrDefault(charToAdd, 0) + 1);
            while ((right - left + 1) - k > Collections.max(map.values())) {
                char charToRemove = s.charAt(left++);
                map.put(charToRemove, map.get(charToRemove) - 1);
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
