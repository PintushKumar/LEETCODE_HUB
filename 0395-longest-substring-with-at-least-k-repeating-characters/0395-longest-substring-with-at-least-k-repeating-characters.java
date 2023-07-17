import java.util.HashMap;

class Solution {
    public static int longestSubstringHavingXuniqueAtLeatKRep(String s, int x, int k) {
        // Initialize variables to keep track of repeat and unique characters
        int nuoRepeat = 0; // Number of characters that repeat exactly 'k' times
        int numOfUnique = 0; // Number of unique characters within the current window
        int sp = 0, ep = 0; // Start and end pointers for the sliding window
        int ans = 0; // Variable to store the answer (maximum length of substring)
        HashMap<Character, Integer> hm = new HashMap<>(); // HashMap to track character frequency

        // Loop through the string using the sliding window approach
        while (ep < s.length()) {
            char chep = s.charAt(ep);
            hm.put(chep, hm.getOrDefault(chep, 0) + 1);

            // Check if the character is unique (first occurrence in the window)
            if (hm.get(chep) == 1) {
                numOfUnique++;
            }

            // Check if the character occurs exactly 'k' times
            if (hm.get(chep) == k) {
                nuoRepeat++;
            }

            // Reduce window size until the number of unique characters becomes 'x'
            while (numOfUnique > x) {
                char chsp = s.charAt(sp);
                hm.put(chsp, hm.get(chsp) - 1);
                if (hm.get(chsp) == 0) {
                    numOfUnique--;
                }
                if (hm.get(chsp) == k - 1) {
                    nuoRepeat--;
                }
                sp++;
            }

            // Check if the current window contains exactly 'x' unique characters,
            // and all characters repeat 'k' times
            if (nuoRepeat == x && numOfUnique == x) {
                ans = Math.max(ans, ep - sp + 1);
            }

            ep++;
        }

        return ans;
    }

    public int longestSubstring(String s, int k) {
        int ans = 0;
        // Check for all possible values of 'x' (1 to 26, as there are 26 alphabets)
        for (int i = 1; i <= 26; i++) {
            ans = Math.max(ans, longestSubstringHavingXuniqueAtLeatKRep(s, i, k));
        }
        return ans;
    }
}
