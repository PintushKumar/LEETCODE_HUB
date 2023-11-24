// class Solution {
//     public int maxCoins(int[] piles) {
//         int n = piles.length;
//         int m = n-2;
//         int b=0;
//         int result =0;
//         Arrays.sort(piles);
//         while(m>b){
//             result+=piles[m];
//             m-=2;
//             b++;
//         }
//         return result;
//     }
// }

class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int result =0;
        Arrays.sort(piles);
        for(int i=n/3;i<n;i+=2){
            result+=piles[i];
        }
        return result;
    }
}