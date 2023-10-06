class Solution {
    public int countGoodSubstrings(String s) {
        int i=0 , j=0;
        int count =0;
        HashMap<Character , Integer> map = new HashMap<>();
        while(i<s.length()){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            if((i-j+1)==3 ){
                if(map.size()==3){
                    count++;
                }
                if(map.containsKey(s.charAt(j))){
                    int freq = map.get(s.charAt(j));
                    if(freq ==1){
                        map.remove(s.charAt(j));
                    }else{
                        map.put(s.charAt(j) , map.getOrDefault(s.charAt(j) , 0)-1);
                    }
                }
                j++;
            }
           
            
            i++;
        }
        return count;
    }
}