class Solution {
    public int firstIndex(int []nums , int n , int target){
        int low =0 , high = n-1 , pans =-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(nums[mid]== target){
                pans = mid;
                high = mid-1;  // going as much as left 
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return pans;
    }

    public int lastIndex(int []nums , int n , int target){
        int low =0 , high = n-1 , pans =-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(nums[mid]== target){
                pans = mid;
                low = mid+1;  // going as much as left 
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return pans;
    }
    public int[] searchRange(int[] nums, int target) {

        // ******************* My solution ************************************
        // int[] res = new int[2];
        // res[0] = res[1] = -1;
        // // If there is only one element in the array
        // if (nums.length == 1 && target == nums[0]) {
        //     res[0] = res[1] = 0; // Only one element and it matches the target
        //     return res;
        // } else if (nums.length == 1 && target != nums[0]) {
        //     return res; // Only one element but it doesn't match the target
        // }
        // int st = 0;
        // int n = nums.length;
        // int end = nums.length - 1;
        // // Binary search
        // while (st <= end) {
        //     int mid = (st + end) / 2;
        //     if (nums[mid] == target) {
        //         // Found target element, find leftmost and rightmost occurrences
        //         int x = mid;
        //         while (x >= 0) {
        //             if (nums[x] < target) {
        //                 res[0] = x + 1;
        //                 break;
        //             }
        //             x--;
        //         }
        //         if (res[0] == -1) {
        //             res[0] = 0; // If leftmost index is still -1, update it to 0
        //         }               
        //         x = mid;
        //         while (x < n) {
        //             if (nums[x] > target) {
        //                 res[1] = x - 1;
        //                 break;
        //             }
        //             x++;
        //         }
        //         if (res[1] == -1) {
        //             res[1] = n - 1; // If rightmost index is still -1, update it to n - 1
        //         }
        //         return res; // Return the range of occurrences of the target
        //     } else if (nums[mid] <= target) {
        //         st = mid + 1; // Continue searching in the right half
        //     } else {
        //         end = mid - 1; // Continue searching in the left half
        //     }
        // }
        // return res; // Target element not found, return default result
// ***********************************************************************************
        int n = nums.length;
        int res[]= new int[2];
        int firind = firstIndex(nums ,n , target);
        if(firind ==-1){
            res[0]=res[1]=-1;
        }
        int lasind = lastIndex(nums , n , target);
        res[0]=firind;
        res[1]=lasind;
        return res;
    }
}
