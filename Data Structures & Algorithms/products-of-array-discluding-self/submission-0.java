class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[]pref = new int[len];
        int[]suff = new int[len];
        int[]ans = new int[len];

        pref[0] = 1;
        suff[len-1] = 1;
        int prefProd = 1;
        int suffProd = 1;

        for(int i=1;i<len;i++){
            prefProd *= nums[i-1];
            pref[i] = prefProd;
        }

        for(int i = len-2;i >= 0; i--){
            suffProd *= nums[i+1];
            suff[i] = suffProd;
        }

        for(int i=0;i<len;i++){
            ans[i] = pref[i] * suff[i];
        }

        return ans;
    }
}  
