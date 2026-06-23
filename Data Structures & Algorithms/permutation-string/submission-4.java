class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            set.add(c);
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        for (int i = 0;i < s2.length();++i) {
            char c = s2.charAt(i);

            //
            if (i >= s1.length()) {
                char d = s2.charAt(i - s1.length());
                if (set.contains(d)) {
                    int count = window.containsKey(d) ? window.get(d) + 1 : 1;
                    window.put(d, count);
                }
            }
            
            //
            if (window.containsKey(c)) {
                int count = window.get(c) - 1;
                window.put(c, count);
            }

            boolean pass = true;
            for (int j : window.values()) {
                if (j != 0) {
                    pass = false;
                }
            }
            if (pass) {
                return true;
            }
        }
        return false;
    }
}
