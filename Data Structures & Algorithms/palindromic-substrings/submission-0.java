class Solution {

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {

            int odd = expand(s, i, i);System.out.println("odd: " + odd);
            int even = expand(s, i, i + 1);System.out.println("even: " + even);
            count += odd + even;
        }
        return count;
    }

    public int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
