// Approach 1: Recursive Approach

// class Solution {
//     public int fib(int n) {
//         // Base cases: F(0) = 0, F(1) = 1
//         if(n==0 || n==1){
//             return n;
//         }
//         // Recursive call to calculate F(n) using F(n-1) and F(n-2)
//         return fib(n-1) + fib(n-2);
//     }
// }


// // Approach 2: Dynamic Programming with Memoization

// class Solution {
//     public int helper(int n, int dp[]) {
//         // Base cases: F(0) = 0, F(1) = 1
//         if(n==0 || n==1){
//             return n;
//         }
//         // Check if the value is already calculated and stored in dp
//         if(dp[n] != -1) {
//             return dp[n];
//         }
//         // Calculate F(n) using memoization
//         dp[n] = helper(n-1, dp) + helper(n-2, dp);
//         return dp[n];
//     }
//     public int fib(int n) {
//         int dp[] = new int[31];
//         // Initialize dp with -1 to indicate values not yet calculated
//         Arrays.fill(dp, -1);
//         // Start calculating F(n)
//         return helper(n, dp);
//     }
// }

// // Approach 3: Dynamic Programming (Tabulation)

// class Solution {
//     public int fib(int n) {
//         // Base cases: F(0) = 0, F(1) = 1
//         if(n==0 || n==1){
//             return n;
//         }
//         // Create an array to store Fibonacci numbers
//         int dp[] = new int[31];
//         // Initialize the base cases
//         dp[0] = 0;
//         dp[1] = 1;
//         // Calculate F(2) to F(n) iteratively
//         for(int i=2; i<=n; i++){
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
// }


// Approach 4: Optimized Dynamic Programming (Tabulation)

class Solution {
    public int fib(int n) {
        // Base cases: F(0) = 0, F(1) = 1
        if(n==0 || n==1){
            return n;
        }
        // Initialize variables to store three consecutive Fibonacci numbers
        int first = 0, second = 1, third = 0;
        for(int i=2; i<=n; i++){
            // Calculate F(i) using F(i-1) and F(i-2)
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}