

class WordDictionary {
    private TrieNode root = new TrieNode();

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if (i == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(i);
        if (c == '.') {
            for (int j = 0; j < 26; ++j) {
                if (node.children[j] != null && dfs(word, i + 1, node.children[j])) {
                    return true;
                }
            }
            return false;
        } else {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            return dfs(word, i + 1, node.children[index]);
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[27];
        boolean isEnd = false;
    }
}
