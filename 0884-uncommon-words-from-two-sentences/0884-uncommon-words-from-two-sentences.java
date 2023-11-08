class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String [] sa = s1.split(" ");
        String [] sb = s2.split(" ");
        HashMap<String , Integer> map1 = new HashMap<>();
        HashMap<String , Integer> map2 = new HashMap<>();
        for(String s : sa){
            map1.put(s , map1.getOrDefault(s , 0)+1);
        }
        for(String s : sb){
            map2.put(s , map2.getOrDefault(s , 0)+1);
        }
        
        ArrayList<String> res = new ArrayList<>();
        
        for(String s :sa){
            if(!map2.containsKey(s)){
                int freq = map1.get(s);
                if(freq==1){
                    res.add(s);
                }
            }
        }
        
        for(String s :sb){
            if(!map1.containsKey(s)){
                int freq = map2.get(s);
                if(freq==1){
                    res.add(s);
                }
            }
        }
        
        String ans [] = new String[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        
        return ans;
       
    }
}