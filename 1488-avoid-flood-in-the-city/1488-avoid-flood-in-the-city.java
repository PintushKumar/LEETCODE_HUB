class Solution {
    public int[] avoidFlood(int[] rains) {
        // Create an array to store the result
        int res[] = new int [rains.length];
        // Create a HashMap to store the index of the last rain for each lake
        HashMap<Integer, Integer> rainIndxMap = new HashMap<>();
        // Create a TreeSet to store the indices of the days when it didn't rain
        TreeSet<Integer> notRainIndxSet = new TreeSet<>();
        
        // Iterate through the given array of rains
        for(int i=0; i<rains.length; i++){
            // If the value is 0, it means there's no rain on this day
            if(rains[i]==0){
                // Add the current index to the set of days when it didn't rain
                notRainIndxSet.add(i);
                // Set the default value in the result array to 1
                res[i] = 1;
            } else {
                // If it rained on this day
                if(rainIndxMap.containsKey(rains[i])){
                    // Get the index of the last rain for this lake
                    int rainIndx = rainIndxMap.get(rains[i]);
                    // Find the index of the next day when it didn't rain using TreeSet
                    Integer notRainIndx = notRainIndxSet.higher(rainIndx);
                    
                    // If there's no day available to dry a lake, return an empty array
                    if(notRainIndx == null){
                        return new int[0];
                    } else {
                        // Set the lake to be dried on the next available day
                        res[notRainIndx] = rains[i];
                        // Remove the index from the set to indicate that it's used
                        notRainIndxSet.remove(notRainIndx);
                    }
                }
                // Mark the current day as a rainy day in the result array
                res[i] = -1;
                // Update the index of the last rain for this lake in the HashMap
                rainIndxMap.put(rains[i], i);
            }
        }
        // Return the result array
        return res;
    }
}
