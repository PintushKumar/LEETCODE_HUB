class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // Initialize variables to track the maximum and minimum subarrays
        int maxiSubArr = Integer.MIN_VALUE; // Maximum subarray sum
        int tempMax = 0; // Temporary maximum sum
        
        int miniSubArr = Integer.MAX_VALUE; // Minimum subarray sum
        int tempMin = 0; // Temporary minimum sum
        
        int totalSum = 0; // Total sum of all elements
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i]; // Calculate the total sum of all elements
            
            // Calculate the maximum subarray sum
            int currMax = nums[i]; // Current element
            int prevMax = tempMax + nums[i]; // Maximum sum ending at the previous element
            tempMax = Math.max(currMax, prevMax); // Update temporary maximum sum
            maxiSubArr = Math.max(maxiSubArr, tempMax); // Update maximum subarray sum
            
            // Calculate the minimum subarray sum
            int currmin = nums[i]; // Current element
            int prevmin = tempMin + nums[i]; // Minimum sum ending at the previous element
            tempMin = Math.min(currmin, prevmin); // Update temporary minimum sum
            miniSubArr = Math.min(miniSubArr, tempMin); // Update minimum subarray sum
        }
        
        // If the maximum subarray sum is negative, return it (as there are no positive subarrays)
        if (maxiSubArr < 0) {
            return maxiSubArr;
        }
        
        // Calculate the wrap-around subarray sum and return the maximum of maximum subarray sum and wrap-around sum
        int wrapAround = totalSum - miniSubArr; // Sum of all elements minus the minimum subarray sum
        return Math.max(maxiSubArr, wrapAround);
    }
}
