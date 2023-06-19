//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String string1 = read.readLine();
            String string2 = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.removeChars(string1,string2) );
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution{
    static String removeChars(String string1, String string2){
        // code here
        HashMap<Character,Integer> map =new HashMap<>();
        for(char ch : string2.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        StringBuilder ans = new StringBuilder();
        for(char ch :string1.toCharArray()){
            if(!map.containsKey(ch)){
               ans.append(ch); 
            }
        }
        return ans.toString();
    }
}