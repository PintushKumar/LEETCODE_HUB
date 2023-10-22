class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0)+1);
            int freq = map.getOrDefault(ch , 0);
            if(freq==2){
                return ch;
            }
        }
        return '*';
    }
}