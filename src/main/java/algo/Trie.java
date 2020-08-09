package algo;

public class Trie {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("abc");
        boolean param_2 = obj.search("abcd");
        boolean param_3 = obj.startsWith("d");
        System.out.println(param_2);
        System.out.println(param_3);
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word == "") {
            return;
        }
        char[] cArr = word.toCharArray();
        TrieNode point = root;
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            int index = c - 97;
            TrieNode curNode = point.child[index];
            if (curNode == null) {
                curNode = new TrieNode();
                point.child[index] = curNode;
            }
            curNode.data = c;
            if (i == cArr.length - 1) {
                //当前是叶子结点
                curNode.isLeaf = true;
            }
            point = curNode;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return isMatch(word, true);
    }

    private boolean isMatch(String word, boolean isAllMatch) {
        if (word == null || word.length() <= 0 || root == null) {
            return false;
        }
        TrieNode point = root;
        char[] cArr = word.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            int index = cArr[i] - 97;
            if (point == null || point.child[index] == null) {
                return false;
            }
            TrieNode curNode = point.child[index];
            char c = cArr[i];
            if (curNode.data == null) {
                return false;
            }
            point = point.child[index];
        }
        if (isAllMatch) {
            return point.isLeaf;
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return isMatch(prefix, false);
    }

    public class TrieNode {

        /**
         * 子结点
         */
        private TrieNode[] child;

        /**
         * 对应数据
         */
        private Character data;

        /**
         * 是否是叶子结点
         */
        private boolean isLeaf;

        public TrieNode() {
            child = new TrieNode[26];
        }

    }
}
