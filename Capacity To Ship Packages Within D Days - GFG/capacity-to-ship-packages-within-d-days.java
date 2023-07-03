//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean isPossible(int [] arr , int day , int cap ){
        int numOfDay =0 ,load =0;
        for(int i=0 ; i<arr.length;i++){
            if(load+arr[i]>cap){
                numOfDay=numOfDay+1;
                load=arr[i];
            }else{
                load+=arr[i];
            }
        }
        if(numOfDay<day){
            return true;
        }else{
            return false;
        }
    }
    static int leastWeightCapacity(int[] arr, int N, int D) {
        // code here
        int sum =0 , maxi = Integer.MIN_VALUE;
        for(int ele : arr){
            sum+=ele;
            maxi=Math.max(maxi , ele);
        }
        int low = maxi , high = sum;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(arr , D , mid )){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
};