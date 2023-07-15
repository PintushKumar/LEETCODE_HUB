//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    static int circularSubarraySum(int arr[], int n) {

        // Your code here

        // Variable to store the maximum subarray sum
        int maximumSubArraySum = Integer.MIN_VALUE;

        // Variable to track the temporary maximum sum
        int tempMax = 0;

        // Variable to store the minimum subarray sum
        int minimumSubArraySum = Integer.MAX_VALUE;

        // Variable to track the temporary minimum sum
        int tempMin = 0;

        // Variable to store the total sum of the array
        int totalSum = 0;

        // Loop through the array
        for (int i = 0; i < n; i++) {

            // Calculate the total sum of the array
            totalSum += arr[i];

            // Calculate the maximum subarray sum
            int currMax = arr[i];
            int prevMax = tempMax + arr[i];
            tempMax = Math.max(currMax, prevMax);
            maximumSubArraySum = Math.max(maximumSubArraySum, tempMax);

            // Calculate the minimum subarray sum
            int currMin = arr[i];
            int prevMin = tempMin + arr[i];
            tempMin = Math.min(currMin, prevMin);
            minimumSubArraySum = Math.min(minimumSubArraySum, tempMin);
        }

        // If the maximum subarray sum is negative, return it
        if (maximumSubArraySum < 0) {
            return maximumSubArraySum;
        }

        // Calculate the sum when wrapping around
        int wrappingAround = totalSum - minimumSubArraySum;

        // Return the maximum of the maximum subarray sum and the wrapping sum
        return Math.max(maximumSubArraySum, wrappingAround);
    }
}


