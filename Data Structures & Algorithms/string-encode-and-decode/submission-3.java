class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            int len = strs.get(i).length();
            sb.append(len);
            sb.append("#");
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int num = 0;
            while(str.charAt(i) != '#'){
                num = num * 10 + (str.charAt(i) - '0');                
                i++;
            }
            i++;
            String t = str.substring(i, i+num);
            ans.add(t);
            i = i+num;
        }
        return ans;
    }
}
