class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        int start = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        while(k != 0){
            int val = pq.poll().getKey();
            ans[start] = val;
            start++;
            k--;
        }
        return ans;
    }
}
