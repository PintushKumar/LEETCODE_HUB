class Solution {
    public boolean isMonotonic(int[] nums) {
        
        boolean inc = false;
        boolean dec = false;
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                inc = true;
            }else if(nums[i]>nums[i+1]){
                dec = true;
            }
        }
        
        if(inc==true && dec == true){
            return false;
        }
        
        return true;
        
    }
}