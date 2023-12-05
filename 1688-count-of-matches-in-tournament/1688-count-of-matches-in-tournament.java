class Solution {
    public int numberOfMatches(int n) {
        // int result =0;
        // while(n>0){
        //     if(n%2==0){
        //         result+= n/2;
        //         n/=2;
        //     }else{
        //         result+=(n-1)/2;
        //         n= ((n-1)/2)+1;
        //     }
        // }
        // return result;
        
        int cnt =0;
        while(n>1){
            cnt+=n/2;
            n=(n+1)/2;
        }
        return cnt;

    }
}