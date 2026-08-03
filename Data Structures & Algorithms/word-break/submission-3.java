class Solution {

  
    public boolean wordBreak(String s, List<String> wordList) {
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, 0, wordList, memo);
    }

    private boolean dfs(String s, int i, List<String> wordList, Boolean[] memo) {
        if (i == s.length()) {
            return true;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        for (String word : wordList) {
            if (s.substring(i).startsWith(word) && dfs(s, i + word.length(), wordList, memo)) {
                memo[i] = true;
                return true;
            }
        }
        memo[i] = false;
        return false;
    }
}
