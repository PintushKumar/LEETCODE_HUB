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
    int solve(List<String> arr , int i , String temp , int n , HashMap<String , Integer > dp ){
        if(i>=n){
            return temp.length();
        }
        
        if(dp.containsKey(temp)){
            return dp.get(temp);
        }
        
        int include = 0;
        int exclude = 0;
        if(hasDuplicate(arr.get(i) , temp)){
            exclude = solve(arr , i+1 , temp , n , dp);
        }else{
            exclude = solve(arr , i+1 , temp , n , dp );
            include = solve(arr , i+1 , temp+arr.get(i) , n , dp);
        }
        int result = Math.max(include, exclude);
        dp.put(temp, result);
        return result;
    }
    public int maxLength(List<String> arr) {
        HashMap<String , Integer> dp = new HashMap<>();
        int n = arr.size();
        return solve(arr , 0 , "" , n , dp);
    }
}