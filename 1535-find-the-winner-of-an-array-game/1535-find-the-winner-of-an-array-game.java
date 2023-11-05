class Solution {
    public int getWinner(int[] arr, int k) {
        int win = 0;
        int max = Integer.MIN_VALUE;
        for(int ele:arr){
            max = Math.max(max , ele);
        }
        if(k>=arr.length){
            return max;
        }
        
        int winner = arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]>winner){
                winner = arr[i];
                win =1;
            }else{
                win++;
            }

            if(win>=k || winner ==max){
                return winner;
            }
        }
        return max;
    }
}