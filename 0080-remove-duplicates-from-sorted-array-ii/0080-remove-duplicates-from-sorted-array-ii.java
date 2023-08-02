class Solution {
   public int removeDuplicates(int[] nums) {
       if(nums.length<3){
           return 2;
       }
       int ind = 2;
       for(int i =2;i<nums.length;i++){
           if(nums[i] != nums[ind-2]){
               nums[ind++]= nums[i];
           }
       }
       return ind;
    }
}