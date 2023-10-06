class Solution {
    public int countGoodSubstrings(String s) {
        int i = 0;  // Initialize the 'i' pointer to the beginning of the string.
        int j = 0;  // Initialize the 'j' pointer to the beginning of the string.
        int count = 0;  // Initialize the count to keep track of good substrings.
        HashMap<Character, Integer> map = new HashMap<>();  // Create a HashMap to store character counts.

        while (i < s.length()) {
            // Add the character at the current position to the map and update its count.
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            if ((i - j + 1) == 3) {  // Check if the length of the current substring is 3.
                if (map.size() == 3) {  // Check if there are 3 distinct characters in the substring.
                    count++;  // Increment the count for a good substring.

                }
                // Remove the character at the beginning of the substring.
                if (map.containsKey(s.charAt(j))) {
                    int freq = map.get(s.charAt(j));
                    if (freq == 1) {
                        map.remove(s.charAt(j));  // If only one occurrence, remove from the map.
                    } else {
                        map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);  // Decrement the count.
                    }
                }
                j++;  // Move the 'j' pointer to the next character in the substring.
            }

            i++;  // Move the 'i' pointer to the next character in the string.
        }

        return count;  // Return the total count of good substrings.
    }
}
