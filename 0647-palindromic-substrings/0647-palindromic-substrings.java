class Solution {
    boolean isPalindromic(String s){
        int st =0 , end = s.length()-1;
        while(st<end){
            if(s.charAt(st)  != s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
    public int countSubstrings(String str) {
        // ArrayList<String> s = new ArrayList<>();
        // HashSet<String> hset = new HashSet<>();
        int n = str.length();
        int count =0;
        for(int i=0;i<n;i++){
            StringBuilder st = new StringBuilder();
            for(int j=i;j<n;j++){
               // String sub = str.substring(i,j+1);
                st.append(str.charAt(j));
                if(isPalindromic(st.toString())){
                   // hset.add(st.toString());
                    count++;
                }
            }
        }
        return count;
    }
}