// class Solution {
//     public int peakIndexInMountainArray(int[] arr) {
//         // int st=0 , end = arr.length-1;
//         // while(st<=end){
//         //     // we find the mid
//         //     int mid = (st+end)/2;
//         //     // According to defination of the given problem

//         //     // mid-1 < mid > mid+1 ..... so mid is our ans;
//         //     if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
//         //         return mid;
//         //     }
//         //     // othewise suppose mid-1 < mid < mid+1
//         //     // then our range is also not life before mid
//         //     // mid st = mid+1 ....
//         //     else if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]){
//         //         st = mid+1;
//         //     }
//         //     // else range must be in between end = mid-1
//         //     else{
//         //         end = mid-1;
//         //     }
//         // }
//         // return -1;
//     }
// }

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int si = 0;
        int ei = n-1;
        while(si<=ei)
        {
            int mid = si + (ei - si)/2;
            if((mid > 0 && mid < (n-1)) && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
            {
                return mid;
            }
            else if(mid == 0 || (mid > 0 && mid < (n-1) && arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]))
            {
                si = mid + 1;
            }
            else
            {
                ei = mid - 1;
            }
        }
        return -1;
    }
}