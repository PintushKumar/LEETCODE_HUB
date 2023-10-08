class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer ,Integer> map = new HashMap<>();
        for(int ele:nums2){
            map.put(ele , map.getOrDefault(ele , 0)+1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int ele : nums1 ){
            if(map.containsKey(ele) && map.get(ele)>0){
                list.add(ele);
                map.put(ele , map.getOrDefault(ele , 0)-1);
            }
        }
        
        int res[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        
        return res;
    }
}