class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int nums3 = Integer.MIN_VALUE; // Initialize nums3 to a minimum value.
        Stack<Integer> st = new Stack<>(); // Create a stack to store elements.

        // Traverse the input array in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            // If we find a number smaller than nums3, it means we've found a 132 pattern.
            if (nums[i] < nums3) {
                return true;
            }

            // While the stack is not empty and the top element is smaller than the current number.
            while (!st.isEmpty() && st.peek() < nums[i]) {
                nums3 = st.pop(); // Update nums3 to the popped element.
            }

            st.push(nums[i]); // Push the current number onto the stack.
        }

        return false; // If no 132 pattern is found, return false.
    }
}
