class Solution {
    boolean isVal(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
    public int maxVowels(String s, int k) {
        int cntv =0;
        int i =0 , j=0;
        int maxV = Integer.MIN_VALUE;
        while(i<s.length()){
            if(isVal(s.charAt(i))){
                cntv++;
            }
            if((i-j+1)==k){
                maxV = Math.max(maxV , cntv);
                if(isVal(s.charAt(j))){
                    cntv--;
                }
                j++;
            }
            i++;
        }
        return maxV;
    }
}