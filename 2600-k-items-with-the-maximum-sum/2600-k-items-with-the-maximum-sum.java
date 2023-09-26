// class Solution {
//     public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
//         int total = numOnes-numNegOnes;
//         int one=0;
//         if(total ==0){
//             return 1;
//         }
//         while(k-->0 && total-->0 ){
//             one++;
//         }
//         return one;
//     }
// }



class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        // Calculate the maximum number of ones that can be picked
        int maxOnes = Math.min(numOnes, k);
        
        // Calculate the maximum number of zeros that can be picked
        int maxZeros = Math.min(numZeros, k - maxOnes);
        
        // Calculate the maximum number of negative ones that can be picked
        int maxNegOnes = Math.min(numNegOnes, k - maxOnes - maxZeros);
        
        // Calculate the maximum possible sum
        return maxOnes - maxNegOnes;
    }
}
