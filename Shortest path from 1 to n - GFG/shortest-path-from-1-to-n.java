//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minStep(int n){
        //complete the function here
        int count =0;
        while(n>1){
            if(n%3==0){
                n/=3;
            }else{
                n--;
            }
            count++;
        }
        
        return count;
    }
}
