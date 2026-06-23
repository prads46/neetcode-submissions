class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int[]ans = new int[2];
        while(start < end){
            int curr = numbers[start]+numbers[end];
            if(curr == target){
                ans[0] = start+1;
                ans[1] = end+1;
                return ans;
            }
            else if(curr < target){
                start++;
            }
            else if(curr > target){
                end--;
            }
        }
        return new int[2];
    }
}
