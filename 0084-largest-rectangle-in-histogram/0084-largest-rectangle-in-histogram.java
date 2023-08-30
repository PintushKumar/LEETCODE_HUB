class Solution {
    public int [] next_SumallerEle_Indx_Wise(int hist[] , int n){
        Stack<Integer> st = new Stack<>();
        int nsl[]= new int [n];
        for(int i=0;i<n;i++){
            while(st.size()>0 && hist[i]<hist[st.peek()]){
                int indx = st.pop();
                nsl[indx]=i;
            }
            st.push(i);
        }
        while(st.size()>0){
            int indx = st.pop();
            nsl[indx]=n;
        }
        return nsl;
    }

    public int [] prev_SumallerEle_Indx_Wise(int hist[] , int n){
        Stack<Integer> st = new Stack<>();
        int nsr[]= new int [n];
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && hist[i]<hist[st.peek()]){
                int indx = st.pop();
                nsr[indx]=i;
            }
            st.push(i);
        }
        while(st.size()>0){
            int indx = st.pop();
            nsr[indx]=-1;
        }
        return nsr;
    }
    public int largestRectangleArea(int[] hist) {
        int n = hist.length;
        int next_SumallerEle_Indx [] = next_SumallerEle_Indx_Wise(hist , n);
        int prev_SumallerEle_Indx [] = prev_SumallerEle_Indx_Wise(hist , n);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int h = hist[i];
            int w = next_SumallerEle_Indx[i]-prev_SumallerEle_Indx[i]-1;
            int area = h*w;
            maxArea = Math.max(maxArea , area);
        }
        return maxArea;
    }
}