class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i] , i);
        }
        int n = operations.length;
        int m = operations[0].length;
        for(int i=0;i<n;i++){
            int numsele = operations[i][0];
            int oprEle = operations[i][1];
           // if(hm.containsKey(numsele)){
                int indx = hm.get(numsele);
                nums[indx]= oprEle;
                hm.put(oprEle,indx );
           // }
        }
        return nums;
    }
}