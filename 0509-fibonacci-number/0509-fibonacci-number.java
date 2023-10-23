// Simple solution Using Recursion 

// class Solution {
//     public int fib(int n) {
//         if(n==0 || n==1){
//             return n;
//         }
//         return fib(n-1)+fib(n-2);
//     }
// }

/// DP Approach 

// class Solution {
//     public int helper(int n , int dp[]){
//         if(n==0 || n==1 ){
//             return n;
//         }
//         if(dp[n]!=-1){
//             return dp[n];
//         }
        
//         dp[n] = helper(n-1 , dp) + helper(n-2 , dp);
//         return dp[n];
//     }
//     public int fib(int n) {
//         int dp[] = new int [31];
//         Arrays.fill(dp , -1);
//         return helper(n , dp);
//     }
// }

// class Solution {
//     public int fib(int n) {
//         if(n==0 || n==1 ){
//             return n;
//         }
//         int dp[] = new int [31];
//         dp[0]=0;
//         dp[1]=1;
//         for(int i=2;i<=n;i++){
//             dp[i] = dp[i-1]+dp[i-2];
//         }
//         return dp[n];
//     }
// }

class Solution {
    public int fib(int n) {
        if(n==0 || n==1 ){
            return n;
        }
        int first = 0 , second = 1 , third = 0;
        for(int i=2;i<=n;i++){
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}