class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxi =0;
        for(int i=0;i<sentences.length;i++){
            String st = sentences[i];
            String []arr = st.split(" ");
            maxi = Math.max(maxi , arr.length);
        }
        return maxi;
    }
}