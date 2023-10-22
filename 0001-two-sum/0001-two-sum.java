class Solution {
    public int[] twoSum(int[] nums, int target) {


        // int res[] = new int [2];
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j] == target){
        //             res[0]=i;
        //             res[1]=j;
        //             break;
        //         }
        //     }
        // }
        // return res;

        HashMap<Integer , Integer> mpp = new HashMap<>();
        int res [] = new int[2];
        res[0]=res[1]=-1;
        for(int i=0;i<nums.length;i++){
            int moreNeed = target-nums[i];
            if(mpp.containsKey(moreNeed)){
                res[0]=i;
                res[1]=mpp.get(moreNeed);
                return res;
            }
            mpp.put(nums[i],i);
        }
        return res;   
        
		
    }
}