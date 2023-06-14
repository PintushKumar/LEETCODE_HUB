class Solution {
    public int countOdds(int low, int high) {
        // int count =0;
        // for(int i = low ;i<=high;i=i+2){
        //     if(i%2!=0  || (i+1)%2 != 0 && i<=high){
        //         count++;
        //     }
        // }
        // return count;
        
        if(low%2==0 && high%2 == 0){
            return (high-low)/2;
        }else{
            return ((high-low)/2)+1;
        }
    }
}