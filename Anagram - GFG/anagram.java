//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        if(a.length() != b.length()){
            return false;
        }
        int freqArr[] = new int [26];
        for(int i=0;i<a.length();i++){
            freqArr[a.charAt(i)-97]++;
        }
        for(int i=0;i<b.length();i++){
            freqArr[b.charAt(i)-97]--;
        }
        for(int i=0;i<26;i++){
            if(freqArr[i] != 0){
                return false;
            }
        }
        return true;

    }
}