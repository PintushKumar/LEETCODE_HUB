class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length; // Get the length of the input array

        if (n == 1) return 0; // If the array contains only one element, it is the peak, so return index 0

        if (nums[0] > nums[1]) return 0; // If the first element is greater than the second element, it is a peak, so return index 0

        if (nums[n - 1] > nums[n - 2]) return n - 1; // If the last element is greater than the second-to-last element, it is a peak, so return the last index

        int low = 1, high = n - 2; // Set the low and high indices for the binary search

        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                // If the current element is greater than its neighbors, it is a peak, so return the index
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                // If the current element is greater than its previous neighbor, move the low index to mid + 1
                low = mid + 1;
            } else {
                // If the current element is smaller than its previous neighbor, move the high index to mid - 1
                high = mid - 1;
            }
        }

        return -1; // If no peak is found, return -1
    }
}
