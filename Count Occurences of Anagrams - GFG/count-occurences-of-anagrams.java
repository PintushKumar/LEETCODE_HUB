//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean allZero(int counter[]){
        for(int ele:counter){
            if(ele !=0){
                return false;
            }
        }
        return true;
    }

    int search(String pat, String txt) {
        // code here
        int counter[] = new int [26];
        for(char ch :pat.toCharArray()){
            counter[ch-'a']++;
        }
        int window = pat.length();
        int n = txt.length();
        int i=0 , j=0;
        int count=0;
        while(j<n){
            counter[txt.charAt(j)-'a']--;
            if(j-i+1 == window){
                if(allZero(counter)){
                    count++;
                }
                counter[txt.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return count;
    }
}


// class Solution {
//     public boolean allZero(int[] counter) {
//         for (int ele : counter) {
//             if (ele != 0) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public int search(String pat, String txt) {
//         int k = pat.length();
//         int[] counter = new int[26];
//         for (char ch : pat.toCharArray()) {
//             counter[ch - 'a']++;
//         }
//         int i = 0, j = 0;
//         int n = txt.length();
//         int result = 0;
//         while (j < n) {
//             counter[txt.charAt(j) - 'a']--;
            
//             if (j - i + 1 == k) {
//                 if (allZero(counter)) {
//                     result++;
//                 }
//                 counter[txt.charAt(i) - 'a']++;
//                 i++;
//             }
//             j++;
//         }
//         return result;
//     }
// }
