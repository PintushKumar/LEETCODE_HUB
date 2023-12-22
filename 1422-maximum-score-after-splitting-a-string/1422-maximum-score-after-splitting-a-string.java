class Solution {
    public int maxScore(String s) {
        int zeros=0 , ones =0;
        int score = Integer.MIN_VALUE;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1'){
                ones++;
            }else{
                zeros++;
            }
            score = Math.max(score , zeros-ones);
        }
        
        if(s.charAt(s.length()-1)=='1'){
            ones++;
        }
        
        return score+ones;
    }
}