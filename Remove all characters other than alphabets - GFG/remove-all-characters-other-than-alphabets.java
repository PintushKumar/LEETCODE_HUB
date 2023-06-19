//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.removeSpecialCharacter(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    String removeSpecialCharacter(String s) {
        // code here
        StringBuilder ans = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'){
                ans.append(ch);
            }
        }
        if(ans.length()==0){
            return "-1";
        }
        return ans.toString();
    }
}