//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String str) {
        // your code here
        if(str.length()<26){
            return false;
        }
        
        int count[] = new int [26];
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)<='z' && str.charAt(i)>='a'){
                count[str.charAt(i)-'a']++;
            }
        }
        
        for(int i=0;i<26;i++){
            if(count[i]==0){
                return false;
            }
        }
        
        return true;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends