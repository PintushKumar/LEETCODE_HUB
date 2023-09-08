class Solution {
    public boolean areOccurrencesEqual(String s) {
        int count[] = new int[26];
        for(char ch : s.toCharArray()){
            count[ch-97]++;
        }
        
        boolean flag = false;
        int freq =0;
        for(int i=0;i<26;i++){
            if( count[i] !=0 ){
                freq = count[i];
                break;
            }
        }
        
        for(int i=0;i<26;i++){
            if(freq != count[i] && count[i]!=0){
                return false;
            }
        }
        
        return true;
    }
}