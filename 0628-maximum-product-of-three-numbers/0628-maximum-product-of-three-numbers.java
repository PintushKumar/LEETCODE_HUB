class Solution {
    public int maximumProduct(int[] nums) {
//         int n = nums.length;
//         if(n<3){
//             return 0;
//         }
        
//         int largest = nums[n-1]*nums[n-2]*nums[n-3];
//         int smallest = nums[0]*nums[1]*nums[n-1];
        
//          return largest>smallest ? largest : smallest;
        Arrays.sort(nums);
         //One of the Three Numbers is the maximum value in the array.

         int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
         int b = nums[0] * nums[1] * nums[nums.length - 1];
         return a > b ? a : b;
    }
}