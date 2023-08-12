class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefProd [] = new int[n];
        int sufProd [] = new int [n];
        int res [] = new int [n];

        // calculate  prefixproduct 
        prefProd[0]=1;
        for(int i = 1 ; i<n;i++){
            prefProd[i] = prefProd[i-1]*nums[i-1];
        }
        
        // calculate sufixProduct 
        sufProd[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            sufProd[i] = sufProd[i+1] * nums[i+1];
        }

        for(int i=0;i<n;i++){
            res[i] = prefProd[i]*sufProd[i];
        }

        return res;
    }
}