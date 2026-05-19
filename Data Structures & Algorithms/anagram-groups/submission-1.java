class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            int[]c = new int[26];
            for(int j=0;j<strs[i].length();j++){
                c[strs[i].charAt(j) - 'a']++;
            }
            String s = Arrays.toString(c);
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(strs[i]);        
        }
        return new ArrayList<>(map.values());
    }
}
