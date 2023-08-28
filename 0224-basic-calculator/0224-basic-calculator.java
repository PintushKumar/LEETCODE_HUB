class Solution {
    public int calculate(String s) {
        char str[] = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        int  n = s.length();
        int number =0;
        int result =0;
        int sign =1;
        for(int i=0;i<n;i++){
            char ch = str[i];
            if(Character.isDigit(ch)){
                number = (number * 10)+(ch-'0');
            }else if(ch=='+'){
                result += (sign*number);
                number =0;
                sign = 1;
            }else if(ch=='-'){
                result += (number*sign);
                number =0;
                sign = -1;
            }else if(ch=='('){
                st.push(result);
                st.push(sign);
                result = 0;
                number =0;
                sign = 1;
            }else if(ch==')'){
                result += (number *sign );
                number =0;

                int lastSign = st.peek();
                st.pop();
                int lastResult = st.peek();
                st.pop();
                result *= lastSign;
                result += lastResult;
            }
        }
        result += (number*sign);
        return result;
    }
}