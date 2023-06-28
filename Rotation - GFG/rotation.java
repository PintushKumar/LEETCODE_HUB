//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int low = 0 , high = n-1;
        int ind =-1 , ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid =(low+high)/2;
            if(arr[low]<arr[high]){
                if(arr[low]<ans){
                    ans =arr[low];
                    ind =low;
                }
                break;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                    ans =arr[low];
                    ind =low;
                }
                low=mid+1;
            }else{
                if(arr[mid]<ans){
                    ans =arr[mid];
                    ind =mid;
                }
                high = mid-1;
            }
        }
        return ind;
    }
}