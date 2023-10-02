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
    // Helper function to check if all elements of the counter array are zero
    boolean allZero(int counter[]) {
        for (int ele : counter) {
            if (ele != 0) {
                return false;
            }
        }
        return true;
    }

    // Main function to count occurrences of anagrams of the 'pat' in 'txt'
    int search(String pat, String txt) {
        // Initialize a counter array to store character frequencies
        int counter[] = new int[26];

        // Count character frequencies in the pattern 'pat'
        for (char ch : pat.toCharArray()) {
            counter[ch - 'a']++;
        }

        // Length of the pattern and the text
        int window = pat.length();
        int n = txt.length();

        // Initialize two pointers for the sliding window
        int i = 0, j = 0;

        // Initialize a variable to count occurrences of anagrams
        int count = 0;

        // Slide the window through the text
        while (j < n) {
            // Decrement the character count as it enters the window
            counter[txt.charAt(j) - 'a']--;

            // If the window size matches the pattern size
            if (j - i + 1 == window) {
                // Check if the counter array has all zeros (an anagram is found)
                if (allZero(counter)) {
                    count++;  // Increment the count of anagrams
                }

                // Increment the count for the character leaving the window
                counter[txt.charAt(i) - 'a']++;

                // Move the left pointer to the right
                i++;
            }

            // Move the right pointer to expand the window
            j++;
        }

        // Return the count of anagrams found in the text
        return count;
    }
}


