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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public void solve(String s , List<String> res , StringBuilder sb , boolean visited[]){
        if(sb.length()== s.length()){
            res.add(sb.toString());
            return;
        }
        for(int i =0;i<s.length();i++){
            if(visited[i] || (i > 0 && s.charAt(i) == s.charAt(i - 1) && !visited[i - 1])){
                continue;
            }else{
                visited[i]=true;
                sb.append(s.charAt(i));
                solve(s , res , sb , visited);
                sb.deleteCharAt(sb.length()-1);
                visited[i]= false;
            }
        }
    }
    public List<String> find_permutation(String S) {
        // Code here
        char cha [] = S.toCharArray();
        Arrays.sort(cha);
        String sorteString = new String(cha);
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean visited[] = new boolean[S.length()];
        solve(sorteString , res ,sb , visited);
        return res;
    }
}