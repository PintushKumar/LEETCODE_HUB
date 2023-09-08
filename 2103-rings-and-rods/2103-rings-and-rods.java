class Solution {
    public int countPoints(String rings) {
        // Create a TreeMap to store rods as keys and corresponding ring colors as values
        TreeMap<Integer, HashSet<Character>> map = new TreeMap<>();
        
        // Iterate through the 'rings' string in pairs of characters
        for (int i = 1; i < rings.length(); i += 2) {
            // Extract the rod number (integer) from the second character of the pair
            int key = rings.charAt(i) - '0';
            
            // Retrieve the HashSet of colors for the current rod, or create a new one if it doesn't exist
            HashSet<Character> colors = map.getOrDefault(key, new HashSet<Character>());
            
            // Add the color of the ring to the HashSet associated with the rod
            colors.add(rings.charAt(i - 1));
            
            // Update the map with the updated HashSet of colors for the rod
            map.put(key, colors);
        } 

        // Initialize a counter for rods with all three colors
        int count = 0;

        // Iterate through the values (HashSet of colors) in the TreeMap
        for (Set set : map.values()) {
            // If the size of the HashSet is 3, it means the rod has all three colors
            if (set.size() == 3) {
                count++;
            }
        }

        // Return the count of rods with all three colors
        return count;
    }
}
