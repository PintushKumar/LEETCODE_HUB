class Solution {
    public String minWindow(String s1, String s2) {
        String ans ="";
        HashMap<Character , Integer> map2 = new HashMap<>();
        for(char c:s2.toCharArray()){
            map2.put(c, map2.getOrDefault(c,0)+1);
        }
        HashMap<Character , Integer> map1 = new HashMap<>();
        int mcnt= 0; // matchCount 
        int dmcnt = s2.length();
        int inc =-1 , exc =-1;
        while(true){
            boolean f1 = false , f2 = false;
            // acquire 
            // also you can use while instead of if
            while(inc<s1.length()-1 && mcnt<dmcnt){
                inc++;
                char ch1 = s1.charAt(inc);
                map1.put(ch1 , map1.getOrDefault(ch1 , 0)+1);
                if(map1.getOrDefault(ch1 ,0)<=map2.getOrDefault(ch1 ,0)){
                    mcnt++;
                }
                f1 = true;
            }
             // also you can use while instead of else if
            while (exc<inc && mcnt == dmcnt){
                String pans = s1.substring(exc+1 , inc+1);
                if(ans.length()==0 || pans.length()<ans.length()){
                    ans = pans;
                }
                exc++;
                char ch2 = s1.charAt(exc);
                if(map1.get(ch2)==1){
                    map1.remove(ch2);
                }else{
                    map1.put(ch2 , map1.getOrDefault(ch2 ,0)-1);
                }
                if(map1.getOrDefault(ch2 , 0)<map2.getOrDefault(ch2 , 0)){
                    mcnt--;
                }
                f2=true;
            }
            if(f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }
}