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

class Solution {
    public int findSubString( String s) {

// ***************************** my solution ********************************************************
        
        HashSet<Character> set = new HashSet<>();
         for(char ch:s.toCharArray()){
            set.add(ch);
        }
        int inc =-1 , exc =-1;
        int maxi = Integer.MAX_VALUE;
        HashMap<Character , Integer> map1 = new HashMap<>();
        while(true){
            boolean f1=false , f2 = false;
            while(inc<s.length()-1 && map1.size()<set.size()){
                inc++;
                char c1 = s.charAt(inc);
                map1.put(c1 , map1.getOrDefault(c1 ,0)+1);
                f1 = true;
            }
             while(exc<inc && map1.size()==set.size()){
                // String pans = s.substring(exc+1 , inc+1);
                // if(ans.length()==0 || pans.length()<ans.length()){
                //     ans = pans;
                // }
                maxi = Math.min(maxi ,((inc+1)-(exc+1)));
                exc++;
                char c2 = s.charAt(exc);
                if(map1.get(c2)==1){
                    map1.remove(c2);
                }else{
                    map1.put(c2 , map1.getOrDefault(c2 ,0)-1);
                }
                f2=true;
            }
            if(f1 == false && f2==false){
                break;
            }
        }
      //  return ans.length();
      return maxi;
      
// ********************************* sir solution *************************************************
    
//     StringBuilder sb = new StringBuilder("");
// 		HashSet<Character> set = new HashSet<>();
// 		for (char ch : s.toCharArray()) {
// 			if (set.contains(ch) == true) {
// 				continue;
// 			} else {
// 				sb.append(ch);
// 				set.add(ch);
// 			}
// 		}

// 		String t = sb.toString();

// 		HashMap<Character, Integer> fmap2 = new HashMap<>();
// 		for (char ch : t.toCharArray()) {
// 			fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
// 		}

// 		int inc = -1;
// 		int exc = -1;

// 		int dmcnt = t.length();
// 		int mcnt = 0;

// 		HashMap<Character, Integer> fmap1 = new HashMap<>();
// 		String ans = "";
// 		while (true) {
// 			boolean f1 = false;
// 			boolean f2 = false;
			
// 			// inc
// 			if (inc + 1 < s.length() && dmcnt > mcnt) {
// 				inc += 1;
// 				char ch = s.charAt(inc);

// 				if (fmap2.containsKey(ch) == true) {
// 					if (fmap1.getOrDefault(ch, 0) < fmap2.get(ch)) {
// 						// this char is imp to me
// 						mcnt++;
// 					}
// 				}

// 				fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);

// 				f1 = true;
// 			} 
// 			// exc
// 			else if (exc < inc && dmcnt == mcnt) {
// 				String pans = s.substring(exc + 1, inc + 1);
// 				if (ans == "" || ans.length() > pans.length()) {
// 					ans = pans;
// 				}

// 				exc++;
// 				char ch = s.charAt(exc);

// 				if (fmap2.containsKey(ch) == true) {
// 					if (fmap1.get(ch) <= fmap2.get(ch)) {
// 						mcnt--;
// 					}
// 				}

// 				fmap1.put(ch, fmap1.get(ch) - 1);

// 				if (fmap1.get(ch) == 0) {
// 					fmap1.remove(ch);
// 				}

// 				f2 = true;
// 			}

// 			if (f1 == false && f2 == false) {
// 				break;
// 			}
// 		}

// 		return ans.length();

    }
}