class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]arr = new int[26];
        for (char t : tasks) {
            arr[t - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0){
                pq.offer(arr[i]);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(!pq.isEmpty()){
                int count = pq.poll()-1;
                if(count > 0){
                    q.offer(new int[]{count, time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] <= time){
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
