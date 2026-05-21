class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            int len = strs.get(i).length();
            sb.append(len);
            sb.append('#');
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> ans = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int len = 0;
                while(str.charAt(i) != '#'){
                    len = len * 10 + (str.charAt(i) - '0');
                    i++;
                }

            i++;

            String temp = str.substring(i,i+len);
            ans.add(temp);
            i = i+len;
        }
        return ans;
    }
}
