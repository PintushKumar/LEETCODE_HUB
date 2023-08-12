class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int [] pref = new int [ 1001 ];
        for(int [] trip : trips){
            int numPassenger = trip[0];
            int sp = trip[1];
            int ep = trip[2];
            pref[sp] += numPassenger;
            pref[ep] -= numPassenger;
        }

        for(int i=1;i<1001;i++){
            pref[i] = pref[i-1]+ pref[i];
        }
        
        for(int i=0;i<1001;i++){
            if(pref[i]>capacity){
                return false;
            }
        }
        return true;
    }
}