class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length-1;
        while(left < right){
            int curr = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(curr,max);

            if(heights[left] < heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}
