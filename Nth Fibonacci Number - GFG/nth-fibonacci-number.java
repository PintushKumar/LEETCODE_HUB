//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int mod = 1000000007;
    static int memo(int n , int [] dp){
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[n] != 0){
            return dp[n];
        }
        int fnm1 = memo(n-1 , dp);
        int fnm2 = memo(n-2, dp);
        dp[n] = (fnm1+fnm2)%mod;
        return (fnm1+fnm2)%mod;
    }
    static int nthFibonacci(int n){
        // code here
        int dp[] = new int[n+1];
        return memo(n , dp);
    }
}