//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


// class Solution
// {
//     //Function to find the maximum money the thief can get.
//     public int FindMaxSum(int arr[], int n)
//     {
//         // Your code here
//         int pre = arr[0];
//         int pop = 0;
//         int max = pre;
        
//         for(int i=1; i<n; i++){
//             max = Math.max(pre,pop+arr[i]);
//             pop = pre;
//             pre = max;
//         }
        
//         return max;
//     }
// }

// class Solution
// {
//      public int helper(int arr[] , int i , int n , int dp[]){
//         if(i>=n){
//             return 0;
//         }
//         if(dp[i]!=-1){
//             return dp[i];
//         }
        
//         int steal = arr[i]+helper(arr , i+2 , n , dp);
//         int skip = helper(arr , i+1 , n , dp);
//         dp[i]= Math.max(steal , skip);
//         return dp[i];
//     }
//     //Function to find the maximum money the thief can get.
//     public int FindMaxSum(int arr[], int n)
//     {
//         // Your code here
//         int dp[] = new int [n+1];
//         Arrays.fill(dp , -1);
//         int res = helper(arr , 0 , n , dp);
//         return res;
//     }
// }

class Solution {
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        
        for (int i = 2; i < n; i++) {
            // Calculate the maximum by either skipping the current house or stealing from it.
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }
        
        return dp[n - 1]; // Return the maximum money that can be obtained.
    }
}



