class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate =0;
        for(int i=0;i<nums.length;i++){
            int indx = Math.abs(nums[i]);
            if(nums[indx-1]>0){
                nums[indx-1]=-nums[indx-1];
            }else{
                duplicate = indx;
                break;
            }
        }
        return duplicate;
    }
}