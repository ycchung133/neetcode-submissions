class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        Map<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < s2.length(); ++right) {
            Character c = s2.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if ((right - left + 1) > s1.length()) {
                Character d = s2.charAt(left);
                window.put(d, window.get(d) - 1);
                if (window.get(d) == 0) {
                    window.remove(d);
                }
                left++;
            } 
            
            if ((right - left + 1) == s1.length()) {
                boolean match = window.keySet().size() == need.keySet().size();
                if (match) {
                    for (Character cc : need.keySet()) {
                        if (!window.containsKey(cc)) {
                            match = false;
                            break;
                        }
                        if (!window.get(cc).equals(need.get(cc))) {
                            match = false;
                            break;
                        }
                    }
                }
                if (match) {
                    return true;
                }
            }

            
        }
        return false;
    }
}
