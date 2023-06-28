//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        // Your code here
        
        // Arrays.sort(arr);
        // return arr[0];
        
    //   int min = arr[0];
    //     for(int i=0;i<arr.length;i++){
    //         min = Math.min(arr[i],min);
    //     }
    //     return min;
    
        // int res = Integer.MAX_VALUE;
        // while(low<=high)
        // {
        //     res = Math.min(res,Math.min(arr[low],arr[high]));
        //     low++; high--;
        // }
        // return res;
        
        int res = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[low]<=arr[mid]){
                res = Math.min(res,arr[low]);
                low=mid+1;
            }
            else{
                res = Math.min(res,arr[mid]);
                high=mid-1;
            }
        }
        return res;
        
    }
}