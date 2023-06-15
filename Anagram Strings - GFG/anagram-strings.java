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
    static int areAnagram(String S1, String S2) {
        // code here
        if(S1.length()!=S2.length()){
            return 0;
        }
        int count[] = new int[26];
        for(int i=0;i<S1.length();i++){
            count[S1.charAt(i)-'a']++;
        }
        for(int i=0;i<S2.length();i++){
            count[S2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                return 0;
            }
        }
        return 1;
    }
}