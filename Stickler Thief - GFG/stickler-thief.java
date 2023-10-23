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


// **************  Recursive Solution with Memoization:
/*

class Solution {
    // Recursive helper function to find the maximum money the thief can get.
    public int helper(int arr[], int i, int n, int dp[]) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int steal = arr[i] + helper(arr, i + 2, n, dp);
        int skip = helper(arr, i + 1, n, dp);
        dp[i] = Math.max(steal, skip);
        return dp[i];
    }

    // Function to find the maximum money the thief can get using memoization.
    public int FindMaxSum(int arr[], int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1); // Initialize the DP array with -1 values.
        int res = helper(arr, 0, n, dp);
        return res;
    }
}

*/


/***************************Dynamic Programming Solution with Tabulation:

class Solution {
    // Function to find the maximum money the thief can get using tabulation.
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

*/


//******************Dynamic Programming Solution with Constant Space:


class Solution {
    // Function to find the maximum money the thief can get using constant space.
    public int FindMaxSum(int arr[], int n) {
        // Base cases: If there are no houses or only one house, return the money from that house.
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }

        int prevMax = arr[0];  // Initialize the maximum money up to the first house.
        int currentMax = Math.max(arr[0], arr[1]);  // Initialize the maximum money up to the second house.

        for (int i = 2; i < n; i++) {
            // Calculate the maximum money for the current house by considering whether to steal or skip it.
            int temp = currentMax;  // Store the current maximum before updating it.
            currentMax = Math.max(currentMax, arr[i] + prevMax);  // Update the maximum money up to the current house.
            prevMax = temp;  // Update the maximum money up to the previous house.
        }

        return currentMax;  // Return the maximum money that can be obtained.
    }
}





