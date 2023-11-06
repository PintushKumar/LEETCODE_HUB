
// bruteForce Solution 

// class SeatManager {
//     boolean reserves [];
//     public SeatManager(int n) {
//         reserves = new boolean [n+1];
//     }
    
//     public int reserve() {
//         for(int i=1;i<reserves.length;i++){
//             if(reserves[i]==false){
//                 reserves[i]=true;
//                 return i;
//             }
//         }
//         return -1;
//     }
    
//     public void unreserve(int seatNumber) {
//         reserves [seatNumber] = false;
//     }
// }

class SeatManager {
    TreeSet<Integer> unReserved;
    int seatMarker ;
    public SeatManager(int n) {
        unReserved = new TreeSet<>();
        seatMarker =1;
    }
    
    public int reserve() {
        if(unReserved.size()>0){
            return unReserved.pollFirst();
        }
        int seat = seatMarker;
        seatMarker++;
        return seat;
    }
    
    public void unreserve(int seatNumber) {
        unReserved.add(seatNumber);
    }
}


/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */