class Solution {
    public double myPow(double x, int n) {
     //   if(n==0){
    //         return 1.0;
    //     }
    //     double smallAns=myPow(x,n-1);
    //     return (double)x*smallAns;
    // }
      double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}