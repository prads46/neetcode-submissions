class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points.length <= k){
            return points;
        }
        PriorityQueue<Map.Entry<Double, int[]>> pq = new PriorityQueue<>((a, b) -> Double.compare(a.getKey(), b.getKey()));        
        int[][]ans = new int[k][2];
        for(int i=0;i<points.length;i++){
            double distance = calculateDistance(points[i]);
            pq.add(Map.entry(distance, points[i]));
        }
        int count = 0;
        while(k != 0){
            ans[count] = pq.poll().getValue();
            count++;
            k--;
        }
        return ans;

    }
    public double calculateDistance(int[]point){
        int x1 = point[0];
        int y1 = point[1];
        int x2 = 0;
        int y2 = 0;
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2),2));
    }
}
