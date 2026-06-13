class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2  = s2.length();

        if(len1 > len2){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int start = 0;
        for(int i = 0;i<len1;i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        if(map.equals(map2)){
            return true;
        }

        for(int j = len1; j<len2;j++){
            char ch = s2.charAt(j);
            map2.put(ch, map2.getOrDefault(ch,0)+1);

            int count = map2.get(s2.charAt(start));
            map2.put(s2.charAt(start), count-1);
            if(map2.get(s2.charAt(start)) == 0){
                map2.remove(s2.charAt(start));
            }
            start++;
            if(map.equals(map2)){
                return true;
            }
        }
        return false;
    }
}
