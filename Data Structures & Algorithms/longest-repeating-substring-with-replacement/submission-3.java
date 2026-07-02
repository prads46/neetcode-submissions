class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxFreq = 0;
        int max = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
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
