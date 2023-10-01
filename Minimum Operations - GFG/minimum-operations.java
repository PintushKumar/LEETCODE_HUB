//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int helper(int start , int target){
        if(start>=target){
            return start - target;
        }
        if(start == target){
            return 0;
        }
        if(target%2==0){
            return 1+helper(start , target/2);
        }else{
            return 1+helper(start , target-1);
        }
    }
    public int minOperation(int n)
    {
        //code here.
        return helper(0,n);
    }
}