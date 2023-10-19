class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        int n = strs.length;
        String s = strs[0];
        String t = strs[n-1];
        String ans = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!= t.charAt(i)){
                break;
            }else{
                ans+=s.charAt(i);
            }
        }
        return ans;
    }
}