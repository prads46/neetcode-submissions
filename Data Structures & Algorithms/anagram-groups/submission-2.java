class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[]ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String temp = new String(ch);
            if(map.containsKey(temp)){
                ArrayList<String> t = map.get(temp);
                t.add(strs[i]);
            }
            else{
                map.put(temp, new ArrayList<>(List.of(strs[i])));
            }
        }

        for(String s: map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
}
