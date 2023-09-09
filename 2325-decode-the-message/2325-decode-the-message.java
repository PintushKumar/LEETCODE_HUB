class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character , Character> map = new HashMap<>();
        int c=97;
        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            if(ch ==' '){
                continue;
            }else if(!map.containsKey(ch)){
                map.put(ch , (char)(c++));
            }
        }

        StringBuilder ans = new StringBuilder();

        for(char ch : message.toCharArray()){
            if(ch==' '){
                ans.append(" ");
            }else{
                ans.append(map.get(ch));
            }
        }

        return ans.toString();
    }
}