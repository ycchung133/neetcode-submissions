class PrefixTree {

    private TrieNode root = new TrieNode();

    public PrefixTree() {
         
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.child[index] != null) {
                node = node.child[index];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.child[index] == null) {
                return false;
            }
            node = node.child[index];
        }
        return true;
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }
}
