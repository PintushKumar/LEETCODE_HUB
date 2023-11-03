class Solution {
    public void solve(String s , int indx , List<String> res , StringBuilder sb , HashMap<Integer , String> map){
        if(sb.length()==s.length()){
            res.add(sb.toString());
            return;
        }
        for(int i=indx;i<s.length();i++){
            if(map.containsKey(s.charAt(i)-'0')){
                String st = map.get(s.charAt(i)-'0');
               for (int j = 0; j < st.length(); j++) {
                    sb.append(st.charAt(j));
                    solve(s, i + 1, res, sb, map);  // Change i+1 to i
                    sb.deleteCharAt(sb.length() - 1);
                }

            }
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        HashMap<Integer , String> map = new HashMap<>();
        map.put(2 ,"abc");
        map.put(3 , "def");
        map.put(4,"ghi");
        map.put(5 , "jkl");
        map.put(6, "mno");
        map.put(7 , "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        StringBuilder sb = new StringBuilder();
        solve(digits , 0 , res ,sb , map );
        return res;
    }
}