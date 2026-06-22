class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!h.containsKey(c)) {
                h.put(c, 1);
            } else {
                h.put(c, h.get(c) + 1);
            }
        }
        for (Character c : t.toCharArray()) {
            if (!h.containsKey(c)) {
                return false;
            } else if (h.get(c) == 1) {
                h.remove(c);
            } else {
                h.put(c, h.get(c) - 1);
            }
        }
        return h.isEmpty();
    }
}
