//{ Driver Code Starts
// Initial template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine();
            String S2 = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.areAnagram(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function template for Java
class Solution {
    static int areAnagram(String a, String b) {
        // code here
        int freqArr [] = new int [26];
        for(int i=0;i<a.length();i++){
            freqArr[a.charAt(i)-97]++;
        }
        for(int i=0;i<b.length();i++){
            freqArr[b.charAt(i)-97]--;
        }
        for(int i=0;i<26;i++){
            if(freqArr[i] != 0){
                return 0;
            }
        }

        return 1;
    }
}