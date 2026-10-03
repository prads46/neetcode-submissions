class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backTrack(0, 0, n);
        return res;
    }

    public void backTrack(int open, int close, int n) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        if (open < n) {
            path.append('(');
            backTrack(open + 1, close, n);
            path.deleteCharAt(path.length() - 1);
        }
        if (open > close) {
            path.append(')');
            backTrack(open, close + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}