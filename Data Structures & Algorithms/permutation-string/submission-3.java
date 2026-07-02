class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int start = 0;
        if(len2 < len1){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<len1;i++){
            char c = s1.charAt(i);
            char ch = s2.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            map2.put(ch, map2.getOrDefault(ch,0)+1);
        }
        if(map.equals(map2)){
            return true;
        }
        for(int j=len1;j<len2;j++){
            char c = s2.charAt(j);
            char ch = s2.charAt(start);
            map2.put(c, map2.getOrDefault(c,0)+1);
            int freq = map2.get(ch);
            if(freq == 1){
                map2.remove(ch);
                start++;
            }
            else{
                map2.put(ch, freq-1);
                start++;
            }

            if(map.equals(map2)){
                return true;
            }
        }
        return false;
    }
}
