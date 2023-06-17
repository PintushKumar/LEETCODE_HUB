class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
//         String s1 = "";
//         String s2 = "";
        
//         for (int i = 0; i < word1.length; i++) {
//             s1 += word1[i];
//         }
        
//         for (int i = 0; i < word2.length; i++) {
//             s2 += word2[i];
//         }
        
//         return s1.equals(s2);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String word : word1) {
            s1.append(word);
        }
        for (String word : word2) {
            s2.append(word);
        }
        return Objects.equals(s1.toString(), s2.toString());
    }
}