//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        StringBuilder ans = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();
        int i=0;
        int countChar[]= new int[26];
        for(char ch :A.toCharArray()){
            int indx = ch-'a';
            countChar[indx]++;
            q.add(ch);
            while(q.size()>0 && countChar[q.peek()-'a']>1){
                q.remove();
            }
            if(q.size()==0){
                ans.append('#');
            }else{
                ans.append(q.peek());
            }
        }
        return ans.toString();
    }
}