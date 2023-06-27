//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
       int maxlen =-1;
       HashMap<Character , Integer > map = new HashMap<>();
       int inc =-1 , exc =-1;
       while(true){
           boolean f1 = false , f2 = false;
           while(inc<s.length()-1 && map.size()<=k){
               inc++;
               char ch1 = s.charAt(inc);
               map.put(ch1 , map.getOrDefault(ch1 ,0)+1);
               if(map.size()==k){
                   int len = inc -exc;
                   maxlen = Math.max(maxlen ,len);
               }
               f1 = true;
           }
           
           while(exc<inc && map.size()>k){
               exc++;
               char ch2 = s.charAt(exc);
               if(map.get(ch2)==1){
                   map.remove(ch2);
               }else{
                   map.put(ch2 , map.getOrDefault(ch2 ,0)-1);
               }
               f2=true;
           }
           if(f1==false && f2==false){
               break;
           }
       }
       return maxlen;
    }
}