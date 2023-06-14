class Solution {
    public int trap(int[] height) {
        // brute force approcach
        
        // int res =0;
        // int n = height.length;
        // for(int i=0;i<n;i++){
        //     int lb = height[i];
        //     for(int j=0;j<i;j++){
        //         lb = Math.max(lb , height[j]);
        //     }
        //     int rb = height[i];
        //     for(int j=i+1;j<n;j++){
        //         rb = Math.max(rb , height[j]);
        //     }
        //     res += Math.min(lb,rb)-height[i];
        // }
        // return res;
        
        int n = height.length;
        int res =0;
        int ltmx [] = new int[n];
        int rtmx [] = new int[n];
        
        ltmx[0]=height[0];
        for(int i=1;i<n;i++){
            ltmx[i] = Math.max(ltmx[i-1],height[i]);
        }
        
        rtmx[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rtmx[i] = Math.max(rtmx[i+1],height[i]);
        }
        
        for(int i=0;i<n;i++){
            res += Math.min(ltmx[i],rtmx[i])-height[i];
        }
        return res;
    }
}