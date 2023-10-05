//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String s) {
        // Code here
        int ans =Integer.MAX_VALUE;
        int n =s.length();
        HashMap<Character , Integer> map = new HashMap<>();
        int i=0 , j=0;
        while(i<n){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) ,0)+1);
            if(map.size()==3){
                while(map.size()==3 && j<i){
                    int freq = map.get(s.charAt(j));
                    if(freq==1){
                        map.remove(s.charAt(j));
                    }else{
                        map.put(s.charAt(j) , map.getOrDefault(s.charAt(j) ,0)-1);
                    }
                    ans = Math.min(ans , (i-j+1));
                    j++;
                }
            }
            i++;
        }
        return ans==Integer.MAX_VALUE ?-1:ans;
    }
};
