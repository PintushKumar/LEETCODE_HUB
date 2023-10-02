//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


 /*
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
};
*/
    class Solution{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr , (a ,b)->{
            return b.profit - a.profit;
        });
        
        int maxDeadLine =Integer.MIN_VALUE;
        for(Job jobs : arr){
            maxDeadLine = Math.max(maxDeadLine , jobs.deadline);
        }
        
        int slot[] = new int [maxDeadLine+1];
        Arrays.fill(slot , -1);
        
        int maxProfit =0;
        int jobCount = 0;
        
        for(Job jobs : arr){
            int deadLine = jobs.deadline;
            for(int i =deadLine;i>0;i--){
                if(slot[i]==-1){
                    slot[i]=i;
                    jobCount++;
                    maxProfit += jobs.profit;
                    break;
                }
            }
        }
        int res[]={jobCount , maxProfit};
        return res;
    }
}