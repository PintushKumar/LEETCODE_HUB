class Solution {
    public boolean checkIfPangram(String str) {
        if(str.length()<26){
            return false;
        }
        // int [] freq = new int [26];
        // for(int i=0;i<sentence.length();i++){
        //     freq[sentence.charAt(i)-'a']++;
        // }
        // for(int i=0;i<26;i++){
        //     if(freq[i]==0){
        //         return false;
        //     }
        // }
        // return true;
        HashSet<Character> st=new HashSet<>();
        for(int i=0;i<str.length();i++){
            st.add(str.charAt(i));
        }
        return st.size()==26;
    }
}