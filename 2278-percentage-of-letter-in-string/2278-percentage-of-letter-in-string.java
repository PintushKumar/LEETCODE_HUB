class Solution {
    public int percentageLetter(String s, char letter) {
        int cnt=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)==letter){
               cnt++;
           }
        }
        
        if(cnt==0){
            return 0;
        }
   
        return (cnt*100)/s.length();
    }
}