class Solution {
    public int solve(int n , int dp[] , int res []){
        if(n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        
        for(int i=1;i<=n-1;i++){
            int prod = i*(Math.max(n-i , solve(n-i , dp , res)));
            res[0] = Math.max(res[0] , prod);
        }
        
        dp[n]=res[0];
        return res[0];
    }
    public int integerBreak(int n) {
        int dp [] = new int [n+1];
        Arrays.fill(dp , -1);
        int res [] = {Integer.MIN_VALUE };
        solve(n , dp , res);
        return res[0];
    }
}