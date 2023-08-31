//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

// **************  this is solve first time ********************************

// class Solution {
//     public int findSubString( String s) {

// ***************************** my solution ********************************************************
//  this is giving correct coutput but getting tle if you want to return string then use this code        
    //     HashMap<Character , Integer > map2 = new HashMap<>();
    //      for(char ch:s.toCharArray()){
    //         if(!map2.containsKey(ch)){
    //             map2.put(ch ,1);
    //         }
    //     }
    //     int inc =-1 , exc =-1;
    //     int mcnt = 0 , dmcnt=map2.size();
    //     HashMap<Character , Integer> map1 = new HashMap<>();
    //     int maxi = Integer.MAX_VALUE;
    //     String ans ="";
    //     while(true){
    //         boolean f1=false , f2 = false;
    //         while(inc<s.length()-1 && dmcnt> mcnt){
    //             inc++;
    //             char c1 = s.charAt(inc);
    //             map1.put(c1 , map1.getOrDefault(c1 ,0)+1);
    //             if(map1.getOrDefault(c1 ,0)<=map2.getOrDefault(c1 ,0)){
    //                 mcnt++;
    //             }
    //             f1 = true;
    //         }
    //          while(exc<inc && dmcnt==mcnt){
    //             // String pans = s.substring(exc+1 , inc+1);
    //             // if(ans.length()==0 || pans.length()<ans.length()){
    //             //     ans = pans;
    //             // }
    //             maxi = Math.min(maxi ,((inc+1)-(exc+1)));
    //             exc++;
    //             char c2 = s.charAt(exc);
    //             if(map1.get(c2)==1){
    //                 map1.remove(c2);
    //             }else{
    //                 map1.put(c2 , map1.getOrDefault(c2 ,0)-1);
    //             }
    //             if(map1.getOrDefault(c2 ,0)<map2.getOrDefault(c2 ,0)){
    //                 mcnt--;
    //             }
    //             f2=true;
    //         }
    //         if(f1 == false && f2==false){
    //             break;
    //         }
    //     }
    //   //  return ans.length();
    //   return maxi;
    
// *********************** this Solution is correct *******************************************

//         HashSet<Character > set = new HashSet<>();
//          for(char ch:s.toCharArray()){
//             set.add(ch);
//         }
//         HashMap<Character , Integer> map = new HashMap<>();
//         int inc =-1 , exc = -1;
//         int maxi = Integer.MAX_VALUE;
//         while(true){
//             boolean f1=false , f2 = false;
//             while(inc<s.length()-1 && map.size()<set.size()){
//                 inc++;
//                 char c1 = s.charAt(inc);
//                 map.put(c1 , map.getOrDefault(c1 ,0)+1);
//                 f1 = true;
//             }
//              while(exc<inc && map.size()==set.size()){
//                 maxi = Math.min(maxi ,((inc+1)-(exc+1)));
//                 exc++;
//                 char c2 = s.charAt(exc);
//                 if(map.get(c2)==1){
//                     map.remove(c2);
//                 }else{
//                     map.put(c2 , map.getOrDefault(c2 ,0)-1);
//                 }
//                 f2=true;
//             }
//             if(f1 == false && f2==false){
//                 break;
//             }
//         }
//       return maxi;
//     }
// }




// ***************************************************888
// after long time to solve this ***********************************************

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        HashSet<Character > set = new HashSet<>();
        for(char ch : str.toCharArray()){
            set.add(ch);
        }
        
        int inc =-1 , exc =-1 , ans =Integer.MAX_VALUE;
        HashMap<Character , Integer > map = new HashMap<>();
        while(true){
            boolean f1 = false , f2 = false;
            //acquire
            while(inc < str.length()-1 && map.size()<set.size()){
                inc++;
                char ch = str.charAt(inc);
                map.put(ch , map.getOrDefault(ch , 0)+1);
                f1 = true;
            }
            
            // collect ans and release
            while(exc<inc && map.size()== set.size()){
                ans =Math.min(ans, (inc - exc));
             
                exc++;
                char ch2 = str.charAt(exc);
                if(map.get(ch2)==1){
                    map.remove(ch2);
                }else{
                    map.put(ch2 , map.get(ch2 )-1);
                }
                f2 = true;
            }
            if(f1 == false && f2==false){
                break;
            }
        }
        return ans;
    }
}



