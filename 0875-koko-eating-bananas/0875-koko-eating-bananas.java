class Solution {
    // Function to find the maximum element in an array
    public int maxEle(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        for (int banana : piles) {
            maxi = Math.max(maxi, banana); // Updating maxi if a larger element is found
        }
        return maxi; // Returning the maximum element
    }
    
    // Function to calculate the total time required to eat all bananas at a given eating speed
    int calculateTime(int[] piles, int mid) {
        int totalTime = 0;
        for (int banana : piles) {
            // Calculate the number of hours required to eat the bananas and round it up
            totalTime += Math.ceil((double) banana / (double) mid);
        }
        return totalTime; // Returning the total time required
    }
    
    // Function to find the minimum eating speed required to eat all bananas within a given time
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = maxEle(piles), ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2; // Finding the midpoint between low and high
            int totalTime = calculateTime(piles, mid); // Calculating the total time required at the current eating speed
            if (totalTime <= h) {
                // If the total time is less than or equal to the given time, update the answer and search for lower eating speeds
                ans = mid;
                high = mid - 1;
            } else {
                // If the total time is greater than the given time, search for higher eating speeds
                low = mid + 1;
            }
        }
        return ans; // Returning the minimum eating speed
    }
}
