class Solution {
    public void setZeroes(int[][] matrix) {
        //find out all the row number and column number where we have to turn zero
        //lets first try to brute force it by trying to find out rows and cols which needs to be turned zero

        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
