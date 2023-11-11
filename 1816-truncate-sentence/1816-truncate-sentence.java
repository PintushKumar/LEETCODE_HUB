class Solution {
    public String truncateSentence(String s, int k) {
        int spaceCount =0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)==' '){
                spaceCount++;
                if(spaceCount==k){
                    return s.substring(0,i);
                }
            }
            i++;
        }
        return s.substring(0 , s.length());
    }
}