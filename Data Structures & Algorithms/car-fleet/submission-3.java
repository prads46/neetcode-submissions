class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Double> map = new HashMap<>();    
        int len = position.length;
        for(int i=0;i<len;i++){
            map.put(position[i], (double)(target - position[i])/ speed[i]);
        }
        Arrays.sort(position);
        double lastFleetTime = 0;
        int count = 0;
        for(int i=len-1;i>=0;i--){
            double time = map.get(position[i]);
            if(lastFleetTime < time){
                count++;
                lastFleetTime = time;
            }
        }
        return count;
    }
}
