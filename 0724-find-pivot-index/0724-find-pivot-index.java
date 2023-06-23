class Solution {
    public int pivotIndex(int[] nums) {
        int sum =0;
        for(int num : nums){
            sum+=num;
        }
        int leftsum=0, rightSum=sum;
        for(int i=0;i<nums.length;i++){
            rightSum -=nums[i];
            if(leftsum == rightSum){
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}