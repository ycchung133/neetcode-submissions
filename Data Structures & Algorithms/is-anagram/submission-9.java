class Solution {
    public boolean isAnagram(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        
        return new String(schars).equals(new String(tchars));
    }


    // public boolean isAnagram(String s, String t) {
    //     HashMap<Character, Integer> h = new HashMap<>();

    //     for (int i = 0; i < s.length(); ++ i) {
    //         Character c = s.charAt(i);
    //         if (!h.containsKey(c)) {
    //             h.put(c, 0);
    //         }
    //         h.put(c, h.get(c) + 1);
    //     }
    //     for (int i = 0; i < t.length(); ++ i) {
    //         Character c = t.charAt(i);
    //         if (h.containsKey(c)) {
    //             h.put(c, h.get(c) - 1);
    //             if (h.get(c) == 0) {
    //                 h.remove(c);
    //             } 
    //         } else {
    //             h.put(c, -1);
    //         }

    //     }
    //     return h.isEmpty();
    // }
}
