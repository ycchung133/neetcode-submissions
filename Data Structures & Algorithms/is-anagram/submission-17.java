class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c: t.toCharArray()) {
            int count = map.getOrDefault(c, 0) - 1;
            if (count < 0) {
                return false;
            } else {
                map.put(c, count);
            }
        }
        return true;
    }
}
