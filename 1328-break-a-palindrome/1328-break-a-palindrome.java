class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1){
            return "";
        }
        char str[] = palindrome.toCharArray();
        int n = str.length;
        for(int i=0;i<n/2;i++){
            if(str[i]!='a'){
                str[i]='a';
                return new String(str);
            }
        }
        str[n-1]='b';
        return new String(str);
    }
}