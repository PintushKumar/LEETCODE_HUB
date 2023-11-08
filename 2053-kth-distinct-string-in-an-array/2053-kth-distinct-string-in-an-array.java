class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String , Integer > map = new HashMap<>();
        for(String s : arr){
            map.put(s , map.getOrDefault(s , 0)+1);
        }
        
        for(String s :arr){
            int freq = map.get(s);
            if(freq == 1){
                k--;
                if(k==0){
                    return s;
                }
            }
        }
        return "";
    }
}