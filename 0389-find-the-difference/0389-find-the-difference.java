class Solution {
    public char findTheDifference(String s, String t) {
    //    // ***********  1st Approach **************
    /*

    HashMap<Character , Integer > map = new HashMap<>();
    for(char ch : s.toCharArray()){
        map.put(ch , map.getOrDefault(ch , 0)+1);
    }
    char chAns= '*';
    for(char ch :t.toCharArray()){
        if(!map.containsKey(ch)){
            return  ch;
        }
        if(map.get(ch)==1){
            map.remove(ch);
        }else {
            map.put(ch , map.getOrDefault(ch , 0)-1);
        }
        if(map.size()==0){
            chAns = ch;
        }
    }
    return chAns;
    
    */

    // ***********  2nd Approach **************
   /*

    int sum =0;
    for(char ch : t.toCharArray())
      sum+=ch;
    for(char ch :s.toCharArray())
      sum-=ch;
    return (char)sum;

    */
    
// ******************* 3rd Approach **********************
    int xor =0;
    for(char ch : t.toCharArray())
      xor^=ch;
    for(char ch :s.toCharArray())
      xor^=ch;
    return (char)xor;

    }
}