class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int num2 = st.pop();
                int num1 = st.pop();
                int currVal = tempEval(num1, num2, s);
                st.push(currVal);
            }
            else{
                int num = Integer.parseInt(s);
                st.push(num);
            }
        }
        return st.peek();
    }
    public int tempEval(int num1, int num2, String operator){
        if(operator.equals("+")){
            return num1 + num2;
        }
        else if(operator.equals("-")){
            return num1 - num2;
        }
        else if(operator.equals("*")){
            return num1 * num2;
        }
        return num1 / num2;
    }
}
