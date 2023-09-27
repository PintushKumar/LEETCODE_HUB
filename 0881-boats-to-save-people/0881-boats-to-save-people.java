class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Initialize the number of boats to 0.
        int boats = 0;
        // Get the total number of people.
        int n = people.length;
        // Initialize pointers i and j to the first and last persons.
        int i = 0, j = n - 1;
        // Sort the people array in ascending order by their weights.
        Arrays.sort(people);
        
        // Iterate through the people using two pointers.
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                // If the sum of weights of persons at pointers i and j is less than or equal to the limit:
                // - Put those two people in the same boat.
                // - Increment the boats count.
                // - Move to the next person from the front (i++) and the next person from the back (j--).
                boats++;
                i++;
                j--;
            } else {
                // If the sum of weights exceeds the limit:
                // - Put the heaviest person (at index j) in a boat.
                // - Increment the boats count.
                // - Move to the next person from the back (j--).
                boats++;
                j--;
            }
        }
        
        // Return the total number of boats required to carry all people.
        return boats;
    }
}
