class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        List<Integer> list = new ArrayList<>();

        while(left <= right && top <= bottom){
            if(top == bottom && left == right){
                list.add(matrix[top][left]);
            }
            else if(top == bottom){
                for(int i=0;i<right-left+1;i++){
                    list.add(matrix[top][left+i]);
                }
            }
            else if(left == right){
                for(int i=0;i<bottom - top + 1;i++){
                    list.add(matrix[top+i][right]);
                }
            }
            else{
                for(int i=0;i<right-left;i++){
                    list.add(matrix[top][left+i]);
                }
                for(int i=0; i<bottom-top;i++){
                    list.add(matrix[top+i][right]);
                }
                for(int i=0; i<right - left; i++){
                    list.add(matrix[bottom][right-i]);
                }
                for(int i=0; i<bottom-top; i++){
                    list.add(matrix[bottom-i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
