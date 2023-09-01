//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String str1, String str2)
    {
        // Your code here

// this code giving me time limit exceeded *************************************************
//********************************************************************************
        // HashMap<Character , Integer > map2 = new HashMap<>();
        // for(char ch : str2.toCharArray()){
        //     map2.put(ch , map2.getOrDefault(ch , 0)+1);
        // }
        // HashMap<Character , Integer > map1 = new HashMap<>();
        // int inc = -1;
        // int exc = -1;
        // int mcnt =0;
        // int dmcnt = str2.length();
        // String ans = "";
        // while(true){
            
        //     boolean f1 = false , f2 = false;
        //     // acquire 
        //     while(inc<str1.length()-1 && mcnt < dmcnt){
        //         inc++;
        //         char ch = str1.charAt(inc);
        //         map1.put(ch , map1.getOrDefault(ch , 0)+1);
        //         if(map1.getOrDefault(ch , 0)<= map2.getOrDefault(ch , 0)){
        //             mcnt++;
        //         }
        //         f1=true;
        //     }
            
        //     // collect answer and release
            
        //     while(exc<inc && mcnt == dmcnt){
        //         String pans = str1.substring(exc+1 , inc+1);
        //         if(ans.length()==0 || pans.length()<ans.length()){
        //             ans = pans;
        //         }
                
        //         exc++;
        //         char ch = str1.charAt(exc);
        //         if(map1.get(ch)==1){
        //             map1.remove(ch);
        //         }else{
        //             map1.put(ch , map1.getOrDefault(ch , 0)-1);
        //         }
                
                
        //         if(map1.getOrDefault(ch ,0) <map2.getOrDefault(ch ,0)){
        //             mcnt--;
        //         }
        //         f2 = true;
        //     }
            
        //     if(f1==false && f2 == false){
        //         break;
        //     }
        // }
        // if(ans.length()==0){
        //     return "-1";
        // }
        // return ans;
        
        //**************************************************************
        
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char ch : str2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        int left = 0; // Left pointer of the window
        int minLen = Integer.MAX_VALUE;
        int minStart = 0; // Starting index of the minimum window
        int mcnt = 0; // Count of characters in str2 that are present in the current window

        for (int right = 0; right < str1.length(); right++) {
            char ch = str1.charAt(right);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);

            if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
                mcnt++;
            }

            while (mcnt == str2.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = str1.charAt(left);
                map1.put(leftChar, map1.get(leftChar) - 1);

                if (map1.getOrDefault(leftChar, 0) < map2.getOrDefault(leftChar, 0)) {
                    mcnt--;
                }

                left++; // Move the left pointer to the right
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "-1";
        }

        return str1.substring(minStart, minStart + minLen);
    }
}