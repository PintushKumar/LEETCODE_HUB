// class Pair{
//     int price ;
//     int span ;
//     public Pair( int price , int span){
//         this.price = price;
//         this.span = span;
//     }
// }
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int res [] = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            int tempr = temperatures[i];
            while(st.size()>0 && tempr>temperatures[st.peek()]){
                int prevIndx = st.peek();
                res[st.peek()]= i - prevIndx;
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}