class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if(n<3){
            return 0;
        }
        
        Arrays.sort(nums);
        int largest = nums[n-1]*nums[n-2]*nums[n-3];
        int smallest = nums[0]*nums[1]*nums[n-1];
        
         return largest>smallest ? largest : smallest;
    }
}