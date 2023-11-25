class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int result[] = new int [n];
        int total_sum =0;

        for(int ele:nums)
            total_sum+=ele;
        
        int prefix_Sum = 0;

        for(int i=0;i<n;i++){
            int left_Sum = prefix_Sum;
            int right_Sum = total_sum - prefix_Sum - nums[i];

            int leftCount = i;
            int rightCount = n - i - 1;

            int leftTotal = (leftCount * nums[i]) - left_Sum;
            int rightTotal = right_Sum - (nums[i] * rightCount);

            result[i] = leftTotal + rightTotal;

            prefix_Sum += nums[i];
        }

        return result;

    }
}