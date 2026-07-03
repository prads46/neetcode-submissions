class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int formed = 0;
        int required = 0;
        int minStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<t.length();i++){
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch,0)+1);
        }
        required = map2.size();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
            if(map.get(ch) == map2.get(ch)){
                formed++;
            }

            while(formed == required){
                if(i - start + 1 < minLen){
                    minLen = i - start + 1;
                    minStart = start;
                }
                char toRemove = s.charAt(start);
                map.put(toRemove, map.getOrDefault(toRemove,0)-1);
                if(map2.containsKey(toRemove) && map.get(toRemove) < map2.get(toRemove)){
                    formed--;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
