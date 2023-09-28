class Solution {
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> ev = new ArrayList<>();
        ArrayList<Integer>od = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                ev.add(nums[i]);
            }else{
                od.add(nums[i]);
            }
        }
        Collections.sort(ev);
        Collections.sort(od);
        int evin=0;
        int odin=od.size()-1;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=ev.get(evin++);
            }else{
                nums[i]=od.get(odin--);
            }
        }
        return nums;
    }
}