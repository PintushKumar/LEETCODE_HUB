class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxi = 0;
        int mini = 0;
        int sum=0;
        for(int i =0;i<nums.length;i++){
             sum += nums[i];
            mini = Math.min(mini , sum);
            maxi = Math.max(maxi , sum);
        }
        return Math.abs(maxi -mini);
    }
}