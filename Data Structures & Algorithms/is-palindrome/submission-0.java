class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int h1 = 0;
        int h2 = s.length() - 1;
        boolean result = true;
        for (int i = 0;i < s.length() / 2; ++i) {
            if (s.charAt(h1) != s.charAt(h2)) {
                result = false;
            }
            h1 += 1;
            h2 -= 1;
        }
        return result;
    }
}
