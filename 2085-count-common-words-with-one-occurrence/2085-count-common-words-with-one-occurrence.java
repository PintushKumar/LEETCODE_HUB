class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String , Integer> map1 = new HashMap<>();
        HashMap<String , Integer> map2 = new HashMap<>();
        for(String s : words1){
            map1.put(s , map1.getOrDefault(s , 0)+1);
        }
        for(String s : words2){
            map2.put(s , map2.getOrDefault(s , 0)+1);
        }
        int cnt =0;
        for(String s : words1){
            if(map1.containsKey(s) && map2.containsKey(s)){
                int f1 = map1.get(s);
                int f2 = map2.get(s);
                if(f1==1&&f2==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}