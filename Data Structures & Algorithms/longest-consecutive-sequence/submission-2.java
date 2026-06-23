class Solution {
    public int longestConsecutive(int[] nums) {
        int start = 0;
        Arrays.sort(nums);
        if(nums.length == 0){
            return 0;
        }
        int curr = 1;
        int max = curr;

        for(int i=1;i<nums.length;i++){
            if(nums[i] - nums[i-1] == 1){
                curr++;
                max = Math.max(curr,max);
            }
            else if(nums[i] - nums[i-1] > 1){
                curr = 1;
            }
        }
        return max;
    }
}
