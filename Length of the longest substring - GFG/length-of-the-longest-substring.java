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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        HashMap<Character , Integer> hm = new HashMap<>();
        int start =-1;
        int maxi =0;
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,i);
            }else{
                if(hm.get(ch)>start){
                    start = hm.get(ch);
                }
                hm.put(ch ,i);
            }
            maxi = Math.max(maxi , i-start);
        }
        return maxi;
    }
}