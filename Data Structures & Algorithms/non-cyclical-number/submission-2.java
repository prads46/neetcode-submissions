class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        if(n == 1){
            return true;
        }
        while(n != 1){
           n = sumOfSquare(n);
           if(set.contains(n)){
              return false;
           }
           if(n == 1){
            return true;
           }
           set.add(n);
        }
        return false;    
    }
    public int sumOfSquare(int n){
        int sum = 0;
        while(n != 0){
            int digit = n%10;
            n /= 10;
            sum += (digit * digit);
        }
        return sum;
    }
}
