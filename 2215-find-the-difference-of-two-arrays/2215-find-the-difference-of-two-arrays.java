class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        
        for(int ele: nums2){
            set.add(ele);
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        for(int ele: nums1){
            if(!set.contains(ele) && !one.contains(ele))           
                one.add(ele);  
            set1.add(ele);
        }

        for( int ele: nums2){
            if(!set1.contains(ele) && !two.contains(ele)){
                two.add(ele);
            }
        }

        res.add(one);
        res.add(two);
        return res;
    }
}