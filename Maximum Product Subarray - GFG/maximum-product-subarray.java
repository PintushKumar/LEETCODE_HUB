//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long prefixProd = 1;
        long suffixProd =1;
        long ans = Long.MIN_VALUE;
        for(int i =0;i<n;i++){
            if(prefixProd ==0){
                prefixProd=1;
            }
            if(suffixProd ==0){
                suffixProd=1;
            }
            prefixProd *=arr[i];
            suffixProd *=arr[n-i-1];
            ans = Math.max(ans , Math.max(prefixProd,suffixProd));
        }
        return ans;
    }
}