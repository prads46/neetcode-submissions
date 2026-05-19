class Solution {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            int len = strs.get(i).length();
            sb.append(len);
            sb.append('#');
            sb.append(strs.get(i));
        }
        return sb.toString();
    }
    
    public static ArrayList<String> decode(String strs) {

        ArrayList<String> ans = new ArrayList<>();

        int i = 0;

        while (i < strs.length()) {

            // find length
            int len = 0;

            while (strs.charAt(i) != '#') {
                len = len * 10 + (strs.charAt(i) - '0');
                i++;
            }

            // skip '#'
            i++;

            // extract string
            String word = strs.substring(i, i + len);

            ans.add(word);

            // move pointer
            i += len;
        }

        return ans;
    }
}
