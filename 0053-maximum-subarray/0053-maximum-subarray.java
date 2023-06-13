class Solution {
    public int maxSubArray(int[]nums) {
    //     int n = arr.length;
    //            int ans = Integer.MIN_VALUE;
		// 	if(n==1){
		// 		return arr[n-1];
		// 	}
		// for(int i=0;i<n;i++){
		// 	int sum = arr[i];
		// 	for(int j=i+1;j<n;j++){
		// 		sum+=arr[j];
		// 		ans = Math.max(ans,sum);
		// 		// if(sum <0 || ans <0 && arr[i]>ans || arr[i]>sum){
		// 		// 	 ans = arr[i];
		// 		// }
				
		// 	}
		// }
		// return ans;
      
			int maxi = nums[0];
			int sum=0;
			for(int i=0;i<nums.length;i++){
				sum+=nums[i];
				maxi=Math.max(maxi,sum);
				if(sum<0){
					sum=0;
				}
			}
			return maxi;
    }
}