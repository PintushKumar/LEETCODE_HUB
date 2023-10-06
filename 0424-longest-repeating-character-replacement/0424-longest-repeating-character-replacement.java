class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character , Integer > map = new HashMap<>();
        int n = s.length();
        int i =0 , j=0 ;
        int maxLen = Integer.MIN_VALUE;
        int freq = 0; 
        while(i<n){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0)+1);
            freq = Math.max(freq , map.get(s.charAt(i)));
            int tempK = (i-j+1)-freq;
            // decrese the window
            if(tempK > k){
                map.put(s.charAt(j) , map.getOrDefault(s.charAt(j),0)-1);
                j++;
            }
            maxLen = Math.max(maxLen , (i-j+1));
            i++; // increasing the window size
        }
        return maxLen;
    }
}