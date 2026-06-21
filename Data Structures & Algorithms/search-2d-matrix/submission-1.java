class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int potentialRow = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == target || matrix[i][matrix[i].length - 1] == target){
                return true;
            }
            else if(matrix[i][0] < target && matrix[i][matrix[i].length - 1] > target){
                potentialRow = i;
            }
        }
        if(potentialRow  == Integer.MIN_VALUE){
            return false;
        }
        int start = 0;
        int prLength = matrix[potentialRow].length;
        int end = prLength - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < matrix[potentialRow][mid]){
                end = mid - 1;
            }
            else if(target > matrix[potentialRow][mid]){
                start = mid + 1;
            }
            else if(target == matrix[potentialRow][mid]){
                return true;
            }
        }
        return false;
    }
}
