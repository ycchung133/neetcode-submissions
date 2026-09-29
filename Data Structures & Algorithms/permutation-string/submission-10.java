class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s2.length(); ++i) {
            char charToAdd = s2.charAt(i);
            s2Map.put(charToAdd, s2Map.getOrDefault(charToAdd, 0) + 1);
            if (i < s1.length() - 1) {
                continue;
            } else if (i > s1.length() - 1) {
                char charToRemove = s2.charAt(i - s1.length());
                int count = s2Map.get(charToRemove) - 1;
                if (count == 0) {
                    s2Map.remove(charToRemove);
                } else {
                    s2Map.put(charToRemove, count);
                }
            }
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }
}
