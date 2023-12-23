class Solution {
    public boolean isPathCrossing(String path) {
        int x =0 , y=0;
        HashSet<String> st = new HashSet<>();
        String str = x+"_"+y;
        st.add(str);
        for(char ch : path.toCharArray()){
            if(ch=='E'){
                x++;
            }else if(ch=='W'){
                x--;
            }else if(ch=='N'){
                y++;
            }else{
                y--;
            }
            str = x+"_"+y;
            if(st.contains(str)){
                return true;
            }
            st.add(str);
        }
        return false;
    }
}