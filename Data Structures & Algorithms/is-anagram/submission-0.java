class Solution {
    public boolean isAnagram(String s, String t) {
        char[] c = new char[26];
        char[] ch = new char[26];
        int l1 = s.length();
        int l2 = t.length();

        if(l1 != l2){
            return false;
        }

        for(int i=0;i<l1;i++){
            c[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<l2;i++){
            ch[t.charAt(i) - 'a']++;        
        }

        for(int i=0; i<l1; i++){
            if(c[s.charAt(i) - 'a'] != ch[s.charAt(i) - 'a']){
                return false;
            }
        }
        return true;
    }
}
