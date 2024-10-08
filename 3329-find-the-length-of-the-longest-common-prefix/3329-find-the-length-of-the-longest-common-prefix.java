class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        int maxLen = 0;

        for (int num : arr1) {
            trie.insert(num);
        }

        for (int num : arr2) {
            maxLen = Math.max(maxLen, trie.longestCommonPrefixLength(num));
        }

        return maxLen;
    }

    private class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int num) {
            TrieNode node = root;
            String str = String.valueOf(num);

            for (int i = 0; i < str.length(); i++) {
                int digit = str.charAt(i) - '0';
                if (node.children[digit] == null) {
                    node.children[digit] = new TrieNode();
                }
                node = node.children[digit];
            }
            node.isEnd = true;
        }

        public int longestCommonPrefixLength(int num) {
            TrieNode node = root;
            String str = String.valueOf(num);
            int len = 0;

            for (int i = 0; i < str.length(); i++) {
                int digit = str.charAt(i) - '0';
                if (node.children[digit] == null) {
                    return len;
                }
                node = node.children[digit];
                len++;
            }

            return len;
        }
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[10];
            isEnd = false;
        }
    }
}