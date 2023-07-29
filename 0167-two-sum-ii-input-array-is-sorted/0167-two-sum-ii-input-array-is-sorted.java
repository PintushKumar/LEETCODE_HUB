class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left =0;
        int right = numbers.length-1;
        while(left<right){
            int currSum=numbers[left]+numbers[right];
            if(currSum == target){
                int res[]={left+1 , right+1};
                return res;
            }
            if(currSum<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[0];
    }
}