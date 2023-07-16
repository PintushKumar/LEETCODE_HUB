class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi =0 ,curr =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                curr=0;
            }else{
                curr++;
                maxi = Math.max(maxi,curr);
            }
        }
        return maxi;
    }
}