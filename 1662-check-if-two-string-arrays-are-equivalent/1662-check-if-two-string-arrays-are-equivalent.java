class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//         String s1 = "";
//         String s2 = "";
//         for(int i=0;i<word1.length;i++){
//             s1+=word1[i];
//         }
//         for(int i=0;i<word1.length;i++){
//             s1+=word1[i];
//         }
        
//         char st1[]=s1.toCharArray();
//         char st2 []=s2.toCharArray();
//         if(st1.length != st2.length){
//             return false;
//         }
//         Arrays.sort(st1);
//         Arrays.sort(st2);
//         String finalstr = new String(st1);
//         String finalstr2 = new String(st2);
//         return finalstr.equals(finalstr2);
        String s1 = "";
        String s2 = "";
        
        for (int i = 0; i < word1.length; i++) {
            s1 += word1[i];
        }
        
        for (int i = 0; i < word2.length; i++) {
            s2 += word2[i];
        }
        
        return s1.equals(s2);
    }
}