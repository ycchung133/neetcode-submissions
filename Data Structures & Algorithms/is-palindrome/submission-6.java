class Solution {
    
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }
    
    // public boolean isPalindrome(String s) {
    //     s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    //     int left = 0;
    //     int right = s.length() - 1;

    //     for (int i = 0; i < s.length() / 2; ++i) {
    //         if (s.charAt(left) != s.charAt(right)) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }

    //     return true;
    // }

    // public boolean isPalindrome(String s) {
    //     s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    //     int h1 = 0;
    //     int h2 = s.length() - 1;
    //     boolean result = true;
    //     for (int i = 0;i < s.length() / 2; ++i) {
    //         if (s.charAt(h1) != s.charAt(h2)) {
    //             result = false;
    //         }
    //         h1 += 1;
    //         h2 -= 1;
    //     }
    //     return result;
    // }
}
