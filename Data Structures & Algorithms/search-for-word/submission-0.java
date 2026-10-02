class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                ans = backTrack(board,i,j,0,word);
                if (ans) return ans;
            }
        }
        return ans;
    }
    public boolean backTrack(char[][]board, int row, int col, int index, String word){
        if(index == word.length()){
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(index)) return false;
        char ch = board[row][col];
        board[row][col] = '#';
        boolean ans = backTrack(board, row+1, col, index+1, word) || backTrack(board, row-1, col, index+1,word) || backTrack(board, row, col-1, index+1, word) || backTrack(board, row, col+1, index+1, word);

        board[row][col] = ch;
        return ans;
    }
}
