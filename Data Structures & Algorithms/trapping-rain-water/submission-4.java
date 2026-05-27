class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;

        int ans = 0;

        while(left <= right){
            if(maxLeft < maxRight){
                int curr = Math.max((maxLeft - height[left]),0);
                maxLeft = Math.max(maxLeft,height[left]);
                ans += curr;
                left++;
            }
            else{
                int curr = Math.max((maxRight - height[right]),0);
                maxRight = Math.max(maxRight,height[right]);
                ans += curr;
                right--;
            }
        }
        return ans;
    }
}
