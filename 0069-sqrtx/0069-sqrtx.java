class Solution {
    public int mySqrt(int x) {
        long low = 1 , high =x;
        while(low<=high){
            long mid =(low+high)/2;
            long mds = mid*mid;
            if(mds==x){
                return (int)mid;
            }else if(mds<x){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return (int)high;

    //      long low = 1 , high =x;
	//    // long ans = -1;
	//     while(low<=high){
	//         long mid = (low+high)/2;
	//         if(mid*mid == x){
	//             return (int)mid;
	//         }else if(mid*mid <x){
	//             low=mid+1;
	//         }else{
	//             high = mid-1;
	//         }
	//     }
	//     return(int) high;
    }
}