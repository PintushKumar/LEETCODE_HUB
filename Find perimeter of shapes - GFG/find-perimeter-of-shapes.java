//{ Driver Code Starts
import java.util.*;
class Perimeter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] a = new int[n][m];
			for(int i = 0 ; i < n; i++ )
				for(int j = 0 ; j < m; j++)
					a[i][j] = sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.findPerimeter(a,n,m));
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class GfG
{
    public static int findPerimeter(int[][] mat, int n, int m)
    {
        //add code here.
        int periMeter =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    if(i==0|| mat[i-1][j]==0) periMeter++;
                    if(i==n-1|| mat[i+1][j]==0) periMeter++;
                    if(j==0|| mat[i][j-1]==0) periMeter++;
                    if(j==m-1|| mat[i][j+1]==0) periMeter++;
                }
            }
        }
        return periMeter;
    }
}