//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
     public static void solve(int arr[] , int indx , ArrayList<String> res , StringBuilder sb , HashMap<Integer , String> map){
        if(sb.length()==arr.length){
            res.add(sb.toString());
            return;
        }
        for(int i=indx;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                String st = map.get(arr[i]);
               for (int j = 0; j < st.length(); j++) {
                    sb.append(st.charAt(j));
                    solve(arr, i + 1, res, sb, map);  // Change i+1 to i
                    sb.deleteCharAt(sb.length() - 1);
                }

            }
        }
    }
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int arr[], int N)
    {
        // your code here  
        ArrayList<String> res = new ArrayList<>();
        if(arr.length==0){
            return res;
        }
        HashMap<Integer , String> map = new HashMap<>();
        map.put(2 ,"abc");
        map.put(3 , "def");
        map.put(4,"ghi");
        map.put(5 , "jkl");
        map.put(6, "mno");
        map.put(7 , "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        StringBuilder sb = new StringBuilder();
        solve(arr , 0 , res ,sb , map );
        return res;
    }
}


