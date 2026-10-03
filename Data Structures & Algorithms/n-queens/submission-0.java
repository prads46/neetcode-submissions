class Solution {
    public List<List<String>> res = new ArrayList<>();
    public List<String> path = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> usedCols = new HashSet<>();
        HashSet<Integer> usedDiag1 = new HashSet<>();
        HashSet<Integer> usedDiag2 = new HashSet<>();
        backTrack(n, 0, usedCols, usedDiag1, usedDiag2);
        return res;

    }
    public void backTrack(int n, int row, HashSet<Integer> usedCols, HashSet<Integer> usedDiag1, HashSet<Integer> usedDiag2){
        if(row == n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<n;i++){
            if(usedCols.contains(i) || usedDiag1.contains(row-i) || usedDiag2.contains(row+i)){
                continue;
            }
            String temp = buildString(n, i);
            path.add(temp);
            usedCols.add(i);
            usedDiag1.add(row-i);
            usedDiag2.add(row+i);
            backTrack(n,row+1,usedCols, usedDiag1, usedDiag2);
            path.remove(path.size()-1);
            usedCols.remove(i);
            usedDiag1.remove(row-i);
            usedDiag2.remove(row+i);
        }
    }
    public String buildString(int n, int col){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i == col){
                sb.append("Q");
            }
            else{
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
