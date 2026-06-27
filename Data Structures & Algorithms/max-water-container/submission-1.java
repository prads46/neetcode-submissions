class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int max = Integer.MIN_VALUE;
        while(left < right){
            if(heights[left] < heights[right]){
                int length = right - left;
                int currArea = heights[left] * length;
                max = Math.max(max,currArea);
                left++; 
            }
            else{
                int length = right - left;
                int currArea = heights[right] * length;
                max = Math.max(max,currArea);
                right--;
            }
        }
        return max;
    }
}
