//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        // code here 
        // ArrayList<Integer > ans = new ArrayList<>();
        // HashMap<Integer , Integer >  map = new HashMap<>();
        // int i=0 , j=-1;
        // while(i<=k-2){
        //     i++;
        //     map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
        // }
        // i--;
        // while(i<n-1){
        //     // acquire
        //     i++;
        //     map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
        //     // work
        //     ans.add(map.size());
            
        //     // release
        //     j++;
        //     int freq = map.getOrDefault(arr[j] ,0);
        //     if(freq ==1){
        //         map.remove(arr[j]);
        //     }else{
        //         map.put(arr[j] , map.getOrDefault(arr[j] , freq-1));
        //     }
        //   // i++;
        // }
        // return ans;
        
        ArrayList<Integer > ans = new ArrayList<>();
        HashMap<Integer , Integer >  map = new HashMap<>();
        int i=0 , j=0;
        while(i<k){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
            i++;
        }
        ans.add(map.size());
        while(i<n){
            // acquire
            map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
            // release
            int freq = map.get(arr[j]);
            if(freq ==1){
                map.remove(arr[j]);
            }else{
                map.put(arr[j] , freq-1);
            }
            j++;
            // work
            ans.add(map.size());
            i++;
        }
        return ans;
    }
}

