class Solution {
    public int countHomogenous(String s) {
        int mod = 1000000007;
       int length = 0;
        int res =0;
        for(int i=0;i<s.length();i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1)){
                length+=1;
            }else{
                length=1;
            }
            res=(res+length)%mod;
        }
        return res;
    }
}