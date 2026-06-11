class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int start = 0;
        int maxFreq = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(s.charAt(i), map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            int windowSize = i - start + 1;
            if(windowSize - maxFreq > k){
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                start++;
            }
            else{
                max = Math.max(max, windowSize);
            }
        }
        return max;
    }
}
