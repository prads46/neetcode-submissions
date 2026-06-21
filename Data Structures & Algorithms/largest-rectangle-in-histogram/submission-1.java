class Solution {
    public int largestRectangleArea(int[] heights) {
        heights = Arrays.copyOf(heights, heights.length+1);
        Stack<Integer> st = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int pop = st.pop();
                int currHeight = heights[pop];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max, currHeight * width);
            }
            st.push(i);
        }
        return max == Integer.MIN_VALUE ? heights[0] : max;
    }
}
