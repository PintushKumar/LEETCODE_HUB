//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        //complete the function here
                int low = 0, high = n - 1; // Initialize the low and high indices
        int ind = -1, ans = Integer.MAX_VALUE; // Initialize variables to track the index and minimum value

        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index

            // if (arr[low] < arr[high]) { // If the subarray is already sorted, it means there are 0 rotations
            //     if (arr[low] < ans) {
            //         ans = arr[low];
            //         ind = low;
            //     }
            //     break;
            // }

            if (arr[low] <= arr[mid]) { // If the left subarray is sorted, update the minimum value and move to the right subarray
                if (arr[low] < ans) {
                    ans = arr[low];
                    ind = low;
                }
                low = mid + 1;
            } else { // If the right subarray is sorted, update the minimum value and move to the left subarray
                if (arr[mid] < ans) {
                    ans = arr[mid];
                    ind = mid;
                }
                high = mid - 1;
            }
        }
        return arr[ind]; // Return the index of the minimum value
    }
}
