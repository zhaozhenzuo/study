package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution212 {

    public static void main(String[] args) {
        Solution212 solution212 = new Solution212();
//        String[] words = {"oath", "pea", "eat", "rain"};
//        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"a"};
        char[][] board = {{'a', 'a'}};
        List<String> rList = solution212.findWords(board, words);
        System.out.println(rList);
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length <= 0 || words == null || words.length <= 0) {
            return new ArrayList<>();
        }

        //trie树初始化
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }

        //数据结构初始化
        int rowNum = board.length;
        int colNum = board[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }

        List<String> rList = new ArrayList<>();
        Set<String> rSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, rSet, visited, trie, "");
            }
        }
        rList.addAll(rSet);
        return rList;
    }

    private void dfs(char[][] board, int row, int col,  Set<String> rSet, boolean[][] visited, Trie trie, String rStr) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
            return;
        }
        if (visited[row][col] == true) {
            return;
        }
        rStr += board[row][col];
        if (!trie.startsWith(rStr)) {
            return;
        }
        if (trie.search(rStr)) {
            rSet.add(rStr);
        }
        visited[row][col] = true;
        dfs(board, row - 1, col, rSet, visited, trie, rStr);
        dfs(board, row + 1, col, rSet, visited, trie, rStr);
        dfs(board, row, col + 1, rSet, visited, trie, rStr);
        dfs(board, row, col - 1, rSet, visited, trie, rStr);
        visited[row][col] = false;
    }

    class Trie {
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

}
