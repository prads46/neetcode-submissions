class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        int start = 0;
        while(start < len){
            char ch = s.charAt(start);
            if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            }
            else if((ch == '}' || ch == ']' || ch == ')') && st.size() == 0){
                return false;
            }
            else if((ch == '}' && st.peek() == '{') || (ch == ']' && st.peek() == '[') || (ch == ')' && st.peek() == '(')){
                st.pop();
            }
            else{
                return false;
            }
            start++;
        }
        return st.empty();
    }
}
