class Solution {
    public int maxPower(String s) {
        // int i=1 , j=-1;
        // int max = Integer.MIN_VALUE;
        // while(i<s.length()){
        //     if(s.charAt(i)== s.charAt(i-1)){
        //         max = Math.max(max , (i-j+1));
        //     }else{
        //         j=i;
        //     }
        //     i++;
        // }

        // //max = Math.max(max , (i-j+1));

        // return max == Integer.MIN_VALUE ? 1 : max;


        int count = 1;
        int max = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
                max = Math.max(max , count);
            }else{
                count =1;
            }
        }
        return max;
    }
}