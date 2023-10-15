//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    void preOrderBST(int nums[] , int st , int ed , ArrayList<Integer> preOrder){
        if(st>ed){
            return ;
        }
        int mid = (st+ed)/2;
        preOrder.add(nums[mid]);
        
        preOrderBST(nums , st , mid-1 , preOrder);
        preOrderBST(nums , mid+1 , ed , preOrder);
    }
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrderBST(nums , 0 , nums.length-1 , preOrder);
        int res[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=preOrder.get(i);
        }
        return res;
    }
}