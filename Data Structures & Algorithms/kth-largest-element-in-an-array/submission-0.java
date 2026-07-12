class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1 && k == 1){
            return nums[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while(k != 1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}
