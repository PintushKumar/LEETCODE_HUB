class Solution {
    // Function to check if it is possible to ship all the packages within 'days' using a capacity of 'capSity'
    public boolean isPossible(int[] weights, int capSity, int days) {
        int numOfDays = 0, load = 0;
        
        // Traverse through the weights array
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capSity) {
                numOfDays++; // Increment the number of days taken to ship the packages
                load = weights[i]; // Start loading a new set of packages
            } else {
                load += weights[i]; // Load the package onto the ship
            }
        }
        
        if (numOfDays < days) {
            return true; // It is possible to ship all the packages within 'days' using the given capacity
        } else {
            return false; // It is not possible to ship all the packages within 'days' using the given capacity
        }
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, maxi = Integer.MIN_VALUE;
        
        // Calculate the total weight of all the packages and find the maximum weight among them
        for (int ele : weights) {
            sum += ele; // Update the total weight
            maxi = Math.max(maxi, ele); // Update the maximum weight
        }
        
        int low = maxi, high = sum, ans = -1;
        
        // Binary search to find the minimum capacity needed to ship all the packages within 'days' days
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(weights, mid, days)) {
                ans = mid; // Update the answer with the current mid
                high = mid - 1; // Search in the lower half of the range
            } else {
                low = mid + 1; // Search in the upper half of the range
            }
        }
        
        return ans; // Return the minimum capacity needed to ship all the packages within 'days' days
    }
}
