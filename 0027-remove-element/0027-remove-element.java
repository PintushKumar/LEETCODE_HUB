class Solution {
    public int removeElement(int[] nums, int val) {
      int operation =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
              nums[operation] = nums[i];
              operation++;
            }
        }
        return operation;
    }
}