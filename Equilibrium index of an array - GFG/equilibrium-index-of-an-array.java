//{ Driver Code Starts
import java.util.*;
class Index{
public static void main(String[] args)
 {
	 Scanner sc = new Scanner(System.in);
	 int T = sc.nextInt();
		while(T-- > 0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.findEquilibrium(a,n));
		}
}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
   public static int findEquilibrium(int arr[], int n)
   {
        //add code here.
        int sum =0;
        for(int ele:arr){
            sum+=ele;
        }
        int leftsum =0 , rightsum = sum;
        for(int i=0;i<n;i++){
            rightsum-=arr[i];
            if(leftsum == rightsum){
                return i;
            }
            leftsum+=arr[i];
        }
        return -1;
   }
}