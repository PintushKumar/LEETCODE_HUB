class Solution {
    boolean hasDuplicate(String s , String b){
        char arr[] = new char [26];
        for(char ch : s.toCharArray() ){
            if(arr[ch-'a']>0){
                return true;
            }
            arr[ch-'a']++;
        }
        
        for(char ch : b.toCharArray()){
            if(arr[ch-'a']>0){
                return true;
            }
        }
        return false;
    }
    int solve(List<String> arr , int i , String temp , int n ){
        if(i>=n){
            return temp.length();
        }
        
        int include = 0;
        int exclude = 0;
        if(hasDuplicate(arr.get(i) , temp)){
            exclude = solve(arr , i+1 , temp , n);
        }else{
            exclude = solve(arr , i+1 , temp , n );
            include = solve(arr , i+1 , temp+arr.get(i) , n);
        }
        return Math.max(include , exclude);
    }
    public int maxLength(List<String> arr) {
        int n = arr.size();
        return solve(arr , 0 , "" , n);
    }
}