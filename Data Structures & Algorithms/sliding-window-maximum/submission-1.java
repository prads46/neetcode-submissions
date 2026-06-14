class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]ans =   new int[nums.length-k+1];
        int start = 0;
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for(int i=0;i<k;i++){
            maxHeap.add(Map.entry(nums[i], i));
        }
        if(k == nums.length){
            return new int[] {maxHeap.poll().getKey()};
        }
        else{
            ans[0] = maxHeap.peek().getKey();
        }

        for(int i=k;i<nums.length;i++){
            maxHeap.add(Map.entry(nums[i], i));
            start = i - k + 1;
            while(maxHeap.peek().getValue() < start){
                maxHeap.poll();
            }
            ans[start] = maxHeap.peek().getKey();
        }
        return ans;
    }
}
