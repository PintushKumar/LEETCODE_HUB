class Solution {
      public boolean allZero(int count[]){
        for(int ele:count){
            if(ele!=0){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String p, String s) {
        List<Integer> res = new ArrayList<>();
        int count[] = new int [26];
        for(int i=0;i<p.length();i++){
            count[p.charAt(i)-'a']++;
        }
        int k = p.length();
        int i=0 , j=0;
        while(i<s.length()){
            count[s.charAt(i)-'a']--;
            if((i-j+1)==k){
                if(allZero(count)){
                    return true;
                }
                count[s.charAt(j)-'a']++;
                j++;
            }
            i++;
        }
        return false;
    }
}