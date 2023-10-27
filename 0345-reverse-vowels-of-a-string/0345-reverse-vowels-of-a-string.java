class Solution {
    public boolean isVawel(char ch ){
        return (ch=='a'||ch=='A'||ch=='e'||ch=='E'||ch=='i'||ch=='I'||ch=='o'||ch=='O'||ch=='u'||ch=='U');
    }
    public String reverseVowels(String s) {
        char charArray [] = s.toCharArray();
        int i=0 , j = s.length()-1;
        while(i<=j){
            if(!isVawel(charArray[i])){
                i++;
            }else if(!isVawel(charArray[j])){
                j--;
            }else{
                char ch = charArray[i];
                charArray[i]=charArray[j];
                charArray[j]=ch;
                i++;
                j--;
            }
        }
        return new String(charArray);
    }
}