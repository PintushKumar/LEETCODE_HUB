// class Solution {
//     public boolean possible(int arr[] , int  target ){
//         int low =0 , high =arr.length-1;
//         while(low<=high){
//             int mid = (low+high)/2;
//             if(arr[mid]== target){
//                 return true;
//             }
//             if(arr[mid]<target){
//                 low=mid+1;
//             }else{
//                 high = mid-1;
//             }
//         }
//         return false;
//     }
//     public boolean checkIfExist(int[] arr) {
//         Arrays.sort(arr);
//         for(int i=0;i<arr.length-1;i++){
//             int target = arr[i]/2;
//             if(possible( arr , target )){
//                 return true;
//             }
//         }
//         return false;
//     }
// }
class Solution {
    public boolean possible(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        boolean hasZero = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (hasZero) {
                    return true; // Second occurrence of 0, which satisfies the condition
                }
                hasZero = true;
            } else {
                int target = 2 * arr[i];
                if (possible(arr, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}

