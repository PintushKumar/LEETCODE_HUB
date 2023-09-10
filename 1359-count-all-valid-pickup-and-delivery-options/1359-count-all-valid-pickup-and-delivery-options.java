class Solution {

    public int M = 1000000007;
    
    public int countOrders(int n) {
        if(n == 1)
            return 1;
        long result = 1; 
        for(int i = 2; i<=n; i++) {
            int spaces = (i-1)*2 + 1;
            
            int possibility = spaces * (spaces+1)/2;
            
            result *= possibility;
            
            result %= M;
        }
        return (int)result;
    }
}