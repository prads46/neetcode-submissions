class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        // Step 1: Use the ans array to store the prefix products
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products on the fly using a single variable
        int suffProd = 1;
        for (int i = len - 1; i >= 0; i--) {
            // ans[i] currently holds the prefix product. 
            // We multiply it by the running suffix product.
            ans[i] *= suffProd;
            
            // Update the suffix product for the next element to the left
            suffProd *= nums[i];
        }

        return ans;
    }
}