class Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        int len2 = t.length();

        if(len != len2){
            return false;
        }

        char[]c = s.toCharArray();
        char[]ch = t.toCharArray();

        Arrays.sort(c);
        Arrays.sort(ch);

        for(int i=0;i<len;i++){
            if(c[i] != ch[i]){
                return false;
            }
        }
        return true;
    }
}
