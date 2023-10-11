class Solution {
    public String frequencySort(String s) {
        Map<Character , Integer > map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0)+1);
            max = Math.max(max , map.get(ch));
        }
        
        List<Character> [] buccketSortArr = new List [max+1];
        
        for(Character ch : map.keySet()){
            int freq = map.get(ch);
            if(buccketSortArr[freq]==null){
                buccketSortArr[freq] = new ArrayList<>();
            }
            buccketSortArr[freq].add(ch);
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(int i = buccketSortArr.length-1;i>=0;i--){
            List<Character> list = buccketSortArr[i];
            if(list != null){
                for(Character ch : list){
                    for(int j=0;j<i;j++){
                        ans.append(ch);
                    }
                }
            }
        }
        
        return ans.toString();
               
    }
}