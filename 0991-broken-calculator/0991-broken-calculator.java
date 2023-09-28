class Solution {
    public int brokenCalc(int startValue, int target) {
        // If the start value is greater than or equal to the target,
        // the only operation possible is subtraction.
        if (startValue >= target) {
            return startValue - target;
        }

        // If the start value is already equal to the target, no operations are needed.
        if (startValue == target) {
            return 0;
        }

        // If the target is even, we can reach the target faster by doubling the start value.
        // So, we add 1 (for the double operation) and call the function recursively with target/2.
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        } else {
            // If the target is odd, we can reach it faster by subtracting 1 from the target.
            // So, we add 1 (for the subtract operation) and call the function recursively with target+1.
            return 1 + brokenCalc(startValue, target + 1);
        }
    }
}
