class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]ans = new int [nums.length - k + 1];
        int start = 0;
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        for(int i=0; i<k;i++){
            pq.add(Map.entry(nums[i],i));             
        }
        if(k == nums.length){
            return new int[] {pq.poll().getKey()};
        }{
            ans[0] = pq.peek().getKey();
        }

        for(int i=k;i<nums.length;i++){
            pq.add(Map.entry(nums[i],i));
            start = i-k+1;
            while(pq.peek().getValue() < start){
                pq.poll();
            }
            ans[start] = pq.peek().getKey();
        }
        return ans;
    }
}
