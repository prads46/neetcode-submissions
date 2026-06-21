class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int min = maxPile;
        int start  = 1;
        int end  = maxPile;
        while(start <= end){
            int mid = start + (end - start)/2;
            int hours = calculateHours(piles,mid);
            if(hours <= h){
                min = Math.min(min, mid);
                end = mid - 1;
            }
            else if(hours > h){
                start = mid + 1;
            }
        }
        return min;
    }
    private int calculateHours(int[] piles, int speed){
        int hours = 0;
        for(int pile : piles){
            hours += Math.ceil((double)pile / speed);
        }
        return hours;
    }
}
