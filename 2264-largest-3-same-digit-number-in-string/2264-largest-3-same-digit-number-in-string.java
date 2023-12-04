class Solution {
    public String largestGoodInteger(String nums) {
        char max_char = ' ';
        int max = Integer.MIN_VALUE;
        for(int i=2;i<nums.length();i++){
            if(nums.charAt(i)== nums.charAt(i-1)&& nums.charAt(i)==nums.charAt(i-2)){
                max_char =(char) Math.max(max_char , nums.charAt(i));
            }
        }
        if(max_char == ' '){
            return"";
        }
         return max_char == ' ' ? "" : new String(new char[] { max_char, max_char, max_char });
    }
}