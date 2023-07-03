//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean isPossible(int []nums , int div , int k){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/(double)div);
        }
        if(sum<=k){
            return true;
        }else{
            return false;
        }
    }
    public static int smallestDivisor(int[] nums, int K) {
        int maxi = Integer.MIN_VALUE;
        for(int ele:nums){
            maxi =Math.max(maxi, ele);
        }
        int low =1 ,high = maxi;
        int ans =-1;
        while(low<=high){
            int div =(low+high)/2;
            if(isPossible(nums , div , K)){
                ans = div;
                high = div-1;
            }else{
                low=div+1;
            }
        }
        return ans;
    }
}