class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>(); // HashMap to store characters and their last seen indexes
        int start = -1; // Variable to keep track of the starting index of the current substring
        int maxLen = 0; // Variable to store the length of the longest substring without repeating characters

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end); // Get the current character

            if (!hm.containsKey(ch)) {
                // If the character is not present in the HashMap, add it along with its index
                hm.put(ch, end);
            } else {
                // If the character is already present in the HashMap
                if (hm.get(ch) > start) {
                    // Update the start index if the last occurrence of the character is after the current start index
                    start = hm.get(ch);
                }
                hm.put(ch, end); // Update the last seen index of the character
            }

            maxLen = Math.max(maxLen, end - start); // Update the length of the longest substring without repeating characters
        }

        return maxLen; // Return the length of the longest substring without repeating characters
    }
}