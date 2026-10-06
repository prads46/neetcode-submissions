class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        // 1. insert every word; at the last node, set node.word = word
        for (String s : words) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.word = s;
        }

        List<String> results = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, results);
            }
        }
        return results;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> results) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        // out of bounds? return
        char ch = board[r][c];
        // used cell (we'll mark with '#') or no child for ch? return

        node = node.children.get(ch);
        if (node == null) {
            return;
        }
        if (node.word != null) {
            results.add(node.word);
            node.word = null;
        }
        // if node.word != null: add to results, then set node.word = null

        board[r][c] = '#'; // mark used
        dfs(board, r + 1, c, node, results);
        dfs(board, r - 1, c, node, results);
        dfs(board, r, c + 1, node, results);
        dfs(board, r, c - 1, node, results);
        // dfs on 4 neighbors: (r+1,c) (r-1,c) (r,c+1) (r,c-1)
        board[r][c] = ch; // restore
    }
}