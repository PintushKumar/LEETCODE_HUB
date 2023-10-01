//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends

class Pair {
    int start;
    int end;
    
    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Pair> list = new ArrayList<>();
       
        for (int i = 0; i < n; i++) {
            list.add(new Pair(start[i], end[i]));
        }
      
        Collections.sort(list, (a, b) -> a.end - b.end);
      
        int cnt = 0;
        int prevEnd = Integer.MIN_VALUE;  // Initialize with the end time of the first meeting
      
        for (int i = 0; i < n; i++) {
            int currStart = list.get(i).start;
            int currEnd = list.get(i).end;
            if ( prevEnd < currStart) {
                cnt++;
                prevEnd = currEnd;
            }else{
                prevEnd = Math.min(prevEnd , currEnd);
            }
        }
        
        return cnt;
    }
}