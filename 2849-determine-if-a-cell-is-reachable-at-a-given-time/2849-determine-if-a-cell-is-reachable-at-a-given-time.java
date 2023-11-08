class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        int horizontal_distance = Math.abs(sy-fy);
        int vertical_distance = Math.abs(sx-fx);
        
        if(horizontal_distance==0 && vertical_distance == 0 && t==1){
            return false;
        }
        
        int minTime = Math.max(horizontal_distance , vertical_distance);
        
        if(t < minTime){
            return false;
        }
        
        return true;
    }
}