//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    public int firstIndex(int []nums , int n , int target){
        int low =0 , high = n-1 , pans =-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(nums[mid]== target){
                pans = mid;
                high = mid-1;  
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return pans;
    }

    public int lastIndex(int []nums , int n , int target){
        int low =0 , high = n-1 , pans =-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(nums[mid]== target){
                pans = mid;
                low = mid+1;
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return pans;
    }
    int count(int[] nums, int n, int target) {
        // int count = 0;
        // for(int i=0;i<n;i++){
        //     if(arr[i]==x){
        //         count++;
        //     }
        // }
        // return count;
        int firstInd = firstIndex(nums , n , target);
        if(firstInd==-1){
            return 0;
        }
        int lastInd = lastIndex(nums , n , target);
        return lastInd-firstInd+1;
    }
}