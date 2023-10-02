//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
// class Solution{
//     static long maximumSumSubarray(int k, ArrayList<Integer> arr,int N){
//         // code here
//         long sum =0;
//         long maxSum = Long.MIN_VALUE;
//         int i=0 , j=-1;
//         for(;i<k;i++){
//             sum+=arr.get(i);
//         }
//         i--;
//         maxSum = Math.max(maxSum , sum);
//         while(i<N){
//             if(i-j==k){
//                 sum-=arr.get(j+1);
//                 j++;
//             }
//             sum+=arr.get(i++);
//             maxSum = Math.max(maxSum , sum);
//         }
//         return maxSum;
//     }
// }

class Solution {
    static long maximumSumSubarray(int k, ArrayList<Integer> arr, int N) {
        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        int i = 0, j = -1;
        for (; i < k; i++) {
            sum += arr.get(i);
        }
        i--;
        maxSum = Math.max(maxSum, sum);
        while (i < N - 1) {
            if (i - j == k) {
                sum -= arr.get(j + 1);
                j++;
            }
            i++;
            sum += arr.get(i);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
