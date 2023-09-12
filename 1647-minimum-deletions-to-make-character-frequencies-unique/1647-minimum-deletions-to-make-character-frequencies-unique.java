class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26]; // Create an array to store the frequency of each character ('a' to 'z')
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++; // Count the frequency of each character in the string
        }
        int count = 0; // Initialize a counter for deletions
        Set<Integer> set = new HashSet(); // Create a set to track unique frequencies
        for (int i = 0; i < 26; i++) {
            int frequency = arr[i];
            while (frequency > 0 && set.contains(frequency)) {
                frequency--; // Decrement the frequency until it's unique
                count++;     // Increment the deletion count
            }
            set.add(frequency); // Add the unique frequency to the set
        }
        return count; // Return the minimum deletions required to make the string "good"
    }
}
