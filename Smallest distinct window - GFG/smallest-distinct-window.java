//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        HashSet<Character> set = new HashSet<>();
        for(char ch :str.toCharArray())
              set.add(ch);
        int k = set.size();
        int i=0 , j=0 , ans =Integer.MAX_VALUE ;
        HashMap<Character ,Integer> map = new HashMap<>();
        int n = str.length();
        while(i<n){
            char ch = str.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0)+1);
            if(map.size()==k){
                while(map.size()==k){
                  char ch1 = str.charAt(j);
                  int freq = map.get(ch1);
                  if(freq==1){
                      map.remove(ch1);
                  }else{
                      map.put(ch1 , map.getOrDefault(ch1 , 0)-1);
                  }
                  ans = Math.min(ans , (i-j+1));
                  j++;
                }
            }
            i++;
        }
        return ans;
    }
}