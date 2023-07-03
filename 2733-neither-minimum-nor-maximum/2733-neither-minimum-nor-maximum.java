class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length==2){
            return -1;
        }
        int maxi = Integer.MIN_VALUE  , mini =Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            maxi = Math.max(maxi , nums[i]);
            mini = Math.min(mini , nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != maxi && nums[i]!= mini){
                return nums[i];
            }
        }
        return -1;
    }
}