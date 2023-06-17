class Solution {
    public String getFrequencyString(String s){
        // Create an array to store the frequency of each character
        int freq[] = new int[26];

        // Count the frequency of each character in the string
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        // Initialize a character 'c' with 'a' and a StringBuilder to store the frequency string
        char c = 'a';
        StringBuilder frequency = new StringBuilder();

        // Iterate over the frequency array
        for(int charOccurence : freq){
            // Append the current character and its occurrence count to the frequency string
            frequency.append(c);
            frequency.append(charOccurence);
            c++;
        }

        // Return the frequency string
        return frequency.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // Check if the input array is null or empty
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        // Create a map to store the frequency string as key and corresponding anagrams as values
        Map<String, List<String>> frequencyStringMap = new HashMap<>();

        // Iterate over each string in the input array
        for(String str : strs){
            // Get the frequency string for the current string
            String frequencyString = getFrequencyString(str);

            // Check if the frequency string already exists in the map
            if(frequencyStringMap.containsKey(frequencyString)){
                // If it exists, add the current string to the list of anagrams for that frequency string
                frequencyStringMap.get(frequencyString).add(str);
            }else{
                // If it doesn't exist, create a new list and add the current string as the first anagram
                List<String> temp = new ArrayList<>();
                temp.add(str);
                frequencyStringMap.put(frequencyString, temp);
            }
        }

        // Return a list of lists containing the grouped anagrams
        return new ArrayList<>(frequencyStringMap.values());
    }
}
