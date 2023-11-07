class Solution {
    public int percentageLetter(String s, char letter) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0)+1);
        }
        
        if(!map.containsKey(letter)){
            return 0;
        }
        
        int freq = map.get(letter);
        
        return (freq*100)/s.length();
    }
}