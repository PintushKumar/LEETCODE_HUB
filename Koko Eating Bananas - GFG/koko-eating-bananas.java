//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxiElement(int arr[] , int n){
        int maxi = Integer.MIN_VALUE;
        for(int ele:arr){
            maxi = Math.max(maxi ,ele);
        }
        return maxi;
    }
    public static int totalHourToEat(int arr[], int time){
        int total_Hour =0;
        for(int ele :arr){
            total_Hour += Math.ceil((double)ele/(double)time);
        }
        return total_Hour;
    }
    public static int Solve(int N, int[] piles, int H) {
        // code here
        int ans = 0;
        int low =1 , high = maxiElement(piles,N);
        while(low<=high){
            int mid = (low+high)/2;
            int totalTime = totalHourToEat(piles , mid);
            if(totalTime<=H){
                ans = mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
        
