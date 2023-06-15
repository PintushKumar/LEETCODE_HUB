//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine();
            String S2 = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.conRevstr(S1, S2));
        }
    }
}

// } Driver Code Ends


// User function template for Java

class Solution {
    static String conRevstr(String s1, String s2) {
        // code here
        StringBuilder st1 = new StringBuilder();
        st1.append(s1);
        st1.reverse();
        StringBuilder st2 = new StringBuilder();
        st2.append(s2);
        st2.reverse();
        StringBuilder ans = new StringBuilder();
        ans.append(st2);
        ans.append(st1);
        return ans.toString();
    }
}