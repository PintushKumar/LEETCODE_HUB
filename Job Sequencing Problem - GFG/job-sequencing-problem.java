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


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        /*
        Arrays.sort(arr, (a, b) -> b.profit - a.profit); // Sort jobs by profit in descending order.
        
        int maxDeadline = 0;
        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        
        int jobCount = 0;
        int maxProfit = 0;
        boolean[] slot = new boolean[maxDeadline + 1];
        
        for (Job job : arr) {
            for (int i = job.deadline; i > 0; i--) {
                if (!slot[i]) {
                    slot[i] = true;
                    maxProfit += job.profit;
                    jobCount++;
                    break;
                }
            }
        }
        
        int res[] = { jobCount, maxProfit };
        return res;
        
        */
        
        Arrays.sort(arr , (a , b)->{
            return b.profit-a.profit;
        });
        int maxJobDeadLine=Integer.MIN_VALUE;
        for(Job jobs:arr){
            maxJobDeadLine =Math.max(maxJobDeadLine , jobs.deadline);
        }
        int jobCount=0;
        int keepTrackOfJobCompleted[] = new int [maxJobDeadLine+1];
        Arrays.fill(keepTrackOfJobCompleted , -1);
        int maxProfit = 0;
        for(Job jobs: arr){
            int deadLine = jobs.deadline;
            for(int i=deadLine;i>0;i--){
                if(keepTrackOfJobCompleted[i]==-1){
                    keepTrackOfJobCompleted[i]=i;
                    maxProfit += jobs.profit;
                    jobCount++;
                    break;
                }
            }
        }
        int res[] ={ jobCount , maxProfit};
        return res;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/