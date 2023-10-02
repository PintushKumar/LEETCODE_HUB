class Solution {
    public boolean winnerOfGame(String colors) {
        int alice =0;
        int bob =0;
        int n =colors.length();
        for(int i=1;i<n-1;i++){
            if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i)==colors.charAt(i+1)){
                if(colors.charAt(i)=='A'){
                    alice++;
                }else{
                    bob++;
                }
            }
        }
        return alice>bob;
    }
}