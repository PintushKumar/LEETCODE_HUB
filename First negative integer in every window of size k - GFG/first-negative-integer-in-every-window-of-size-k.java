//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


// class Compute {
    
//     public long[] printFirstNegativeInteger(long arr[], int N, int k)
//     {
//         ArrayList<Long> res = new ArrayList<>();
//         long neg =0;
//         boolean flag = false;
//         int i=0, j=-1;
//         for(;i<k;i++){
//             if(arr[i] <0 && flag == false){
//                 neg = arr[i];
//                 flag =true;
//             }
//         }
//         i--;
//         res.add(neg);
//         while(i<N-1){
//             if(i-j==k){
//                 if(arr[j+1]<0 && flag ==true){
//                     neg = 0;
//                     flag = false;
//                 }
//                 j++;
//             }
//             i++;
//             if(arr[i]<0 && flag ==false){
//                 neg = arr[i];
//                 flag = true;
//             }
//             res.add(neg);
//         }
//         long ans []=new long[res.size()];
//         for(int l=0;l<res.size();l++){
//             ans[l]=res.get(l);
//         }
//         return ans;
//     }
// }

// class Compute {
//     public long[] printFirstNegativeInteger(long arr[], int N, int k) {
//         ArrayList<Long> res = new ArrayList<>();
//         long neg = 0;
//         Dequeue<Long> dq = new ArrayDequeue<>();
//         int i = 0, j = -1;
        
//         for (; i < k; i++) {
//             if (arr[i] < 0) {
//                 dq.addLast(arr[i]);
//             }
//         }
//         i--;
//         if(dq.size()==0){
//             res.add(0);
//         }else{
//             res.add(dq.getFirst());
//         }
        
//         while (i < N - 1) {
//             if (i - j == k) {
//                 if (arr[j + 1] < 0 ) {
//                     dq.removeFirst();
//                 }
//                 j++;
//             }
//             i++;
            
//             if (arr[i] < 0) {
//                 dq.addLas6t(arr[i]);
//             }
//             if(dq.size()==0){
//                 res.add(0);
//             }else{
//                 res.add(dq.getFirst());
//             }
            
//         }
        
//         long ans[] = new long[res.size()];
//         for (int l = 0; l < res.size(); l++) {
//             ans[l] = res.get(l);
//         }
//         return ans;
//     }
// }




class Compute {
    public long[] printFirstNegativeInteger(long arr[], int N, int k) {
        ArrayList<Long> res = new ArrayList<>();
        long neg = 0;
        Deque<Long> dq = new ArrayDeque<>();
        int i = 0, j = -1;

        for (; i < k; i++) {
            if (arr[i] < 0) {
                dq.addLast(arr[i]);
            }
        }
        i--;
        if (dq.size() == 0) {
            res.add(0L);
        } else {
            res.add(dq.getFirst());
        }

        while (i < N - 1) {
            if (i - j == k) {
                if (arr[j + 1] < 0) {
                    dq.removeFirst();
                }
                j++;
            }
            i++;

            if (arr[i] < 0) {
                dq.addLast(arr[i]);
            }
            if (dq.size() == 0) {
                res.add(0L);
            } else {
                res.add(dq.getFirst());
            }
        }

        long ans[] = new long[res.size()];
        for (int l = 0; l < res.size(); l++) {
            ans[l] = res.get(l);
        }
        return ans;
    }
}
