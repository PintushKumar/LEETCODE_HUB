class Solution {
    public int longestOnes(int[] nums, int k) {
        int sp = 0, ep = 0; // Pointers to track the current subarray.
        int ans = 0, numOfZero = 0; // Variables to store the answer and count of zeros.
        int n = nums.length; // Length of the input array.

        while (ep < n) { // Loop until 'ep' reaches the end of the array.
            if (nums[ep] == 0) {
                numOfZero++; // Increment 'numOfZero' if the current element is zero.
            }

            while (numOfZero > k) { // Check if 'numOfZero' exceeds the allowed limit 'k'.
                if (nums[sp] == 0) {
                    numOfZero--; // Decrement 'numOfZero' if the element at 'sp' is zero.
                }
                sp++; // Move the 'sp' pointer to shrink the subarray.
            }

            ans = Math.max(ans, ep - sp + 1); // Update 'ans' to track the maximum subarray length.
            ep++; // Move the 'ep' pointer to expand the subarray.
        }

        return ans; // Return the length of the longest subarray with at most 'k' zeros.
    }

}