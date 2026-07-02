class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && start <= map.get(ch)){
                start = map.get(ch)+1;
                map.put(ch,i);
            }
            else{
                map.put(ch,i);
                max = Math.max(max,i - start+1);
            }
        }
        return max;
    }
}
