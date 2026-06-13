class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int required = map.size();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);

            if(map.get(ch) == map2.get(ch)){
                formed++;
            }

            while(formed == required){
                if(i - start + 1 < minLen){
                    minLen = i - start + 1;
                    minStart = start;
                }

                char leftChar = s.charAt(start);
                map2.put(leftChar, map2.getOrDefault(leftChar,0)-1);

                if(map.containsKey(leftChar) && map2.get(leftChar) < map.get(leftChar)){
                    formed--;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
