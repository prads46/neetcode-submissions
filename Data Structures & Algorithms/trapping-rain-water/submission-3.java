class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        int ans = 0;

        while(left <= right){
            if(maxLeft < maxRight){
                maxLeft = Math.max(maxLeft,height[left]);
                ans += Math.max((maxLeft - height[left]),0);
                left++;
            }
            else {
                maxRight = Math.max(maxRight, height[right]);
                ans += Math.max((maxRight - height[right]),0);
                right--;
            }
        }
        return ans;
    }
}
