class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len <= 1){
            return len;
        }

        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && start <= map.get(ch)){
                start = map.get(ch)+1;
            }
            max = Math.max(i - start + 1, max);
            map.put(ch,i);
        }
        return max;
    }
}
