class Solution {
    // Function to check if it is possible to make m bouquets with k adjacent flowers within 'day' number of days
    public boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int numOfDays = 0, consecutive = 0;
        
        // Traverse through the bloomDay array
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                consecutive++; // Count consecutive bloomed flowers
            } else {
                numOfDays += (consecutive / k); // Update the number of bouquets made so far
                consecutive = 0; // Reset consecutive count
            }
        }
        
        numOfDays += (consecutive / k); // Update the number of bouquets made with remaining consecutive flowers
        
        if (numOfDays >= m) {
            return true; // It is possible to make m bouquets within 'day' number of days
        } else {
            return false; // It is not possible to make m bouquets within 'day' number of days
        }
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        // Calculate the minimum and maximum bloom day
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int ele : bloomDay) {
            mini = Math.min(mini, ele); // Update minimum bloom day
            maxi = Math.max(maxi, ele); // Update maximum bloom day
        }
        
        // Calculate the maximum number of flowers required to make m bouquets
        long notPossible = (long) k * (long) m;
        
        // If the required number of flowers is greater than the total number of flowers available, return -1
        if (notPossible > bloomDay.length) {
            return -1;
        }
        
        int low = mini, high = maxi, ans = -1;
        
        // Binary search to find the minimum number of days needed to make m bouquets
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid; // Update the answer with the current mid
                high = mid - 1; // Search in the lower half of the range
            } else {
                low = mid + 1; // Search in the upper half of the range
            }
        }
        
        return ans; // Return the minimum number of days needed to make m bouquets
    }
}
