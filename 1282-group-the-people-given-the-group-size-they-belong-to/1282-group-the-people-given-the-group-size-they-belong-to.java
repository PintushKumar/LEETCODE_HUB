class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer> > res = new ArrayList<>();
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            int size = groupSizes[i];
            if(!map.containsKey(size)){
                map.put(size , new ArrayList<Integer>());
            }
            map.get(size).add(i);
            if(map.get(size).size()== size){
                res.add(map.get(size));
                map.put(size , new ArrayList<Integer>());
            }
        }
        return res;
    }
}