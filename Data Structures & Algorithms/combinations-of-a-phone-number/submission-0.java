class Solution {
    public List<List<Character>> res = new ArrayList<>();
    public List<Character> path = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>(); 
        map.put('2', "abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        char[]ch = digits.toCharArray();
        backTrack(ch,0, map);
        return listToString(res);
    }
    public void backTrack(char[]ch,int index, HashMap<Character, String> map){
        if(path.size() == ch.length){
            res.add(new ArrayList<>(path));
            return;
        }
        String temp = map.get(ch[index]);
        char[]tempch = temp.toCharArray();
        for(char c: tempch){
            path.add(c);
            backTrack(ch, index+1, map);
            path.remove(path.size()-1);
        }
    }
    public List<String> listToString(List<List<Character>> res){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<res.size();i++){
            StringBuilder sb = new StringBuilder();
            List<Character> temp = res.get(i);
            for(Character c: temp){
                sb.append(c);
            }
            if(sb.length() == 0){
                return ans;
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
