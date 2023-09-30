//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int H = Integer.parseInt(arr[0]);
            int U = Integer.parseInt(arr[1]);
            int D = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.minStep(H, U, D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minStep(int H, int U, int D){
        // code here
      return (H-D)/(U-D)+1;
    }
}