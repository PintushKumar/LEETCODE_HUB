class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if(n==1){
            return arr[0];
        }
        int hlf = (int)Math.floor(n/2);
        int tw = (int)Math.floor(hlf/2);
        int count =1;
        for(int i=1;i<n;i++){
            if(arr[i]== arr[i-1]){
                count++;
                if(count>tw){
                    return arr[i];
                }
            }else{
                count =1;
            }
        }
        return -1;
    }
}