class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer ,Integer> map = new HashMap<>();
        for(int ele:arr){
            map.put(ele , map.getOrDefault(ele , 0)+1);
        }
        
        int largest_LuckyNum = 0;
        for(int ele: arr){
            if(map.get(ele)==ele){
                largest_LuckyNum = Math.max(largest_LuckyNum , ele);
            }
        }
        if(largest_LuckyNum==0)
            return -1;
        return largest_LuckyNum;
    }
}