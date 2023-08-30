class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // int count =0;
        // // generating all the subarray
        // int sum=0;

        // for(int i=0;i<nums.length;i++){
        //   //  int sum =nums[i];
        //    // if(sum/k==0){}
        //     for(int j=i;j<nums.length;j++){
        //         sum+=nums[j];
        //      //  if(sum>0){
        //        if (sum%k ==0){ // checking the sum if sum divisible  by k the increment the count 
        //             count= count+1;
        //         }
               
        //     }
        //     sum =0;
        // }
        // return count;

        HashMap<Integer , Integer > map = new HashMap<>();
        int sum =0 , ans =0;
        map.put(sum , 1);
        for(int ele : nums){
            sum+=ele;
            int rem = (sum %k+k)%k;
            if(map.containsKey(rem)){
                ans+=map.get(rem);
                map.put(rem , map.get(rem)+1);
            }else{
                map.put(rem ,1);
            }
        }
        return ans;
    }
}