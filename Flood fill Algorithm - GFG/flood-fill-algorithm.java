//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public void dfs(int[][] img, int i, int j, int n, int m, int newColor, int oldColor) {
        if (i < 0 || i >= n || j < 0 || j >= m || img[i][j] != oldColor) {
            return;
        }
        img[i][j] = newColor;

        dfs(img, i - 1, j, n, m, newColor, oldColor);
        dfs(img, i + 1, j, n, m, newColor, oldColor);
        dfs(img, i, j - 1, n, m, newColor, oldColor);
        dfs(img, i, j + 1, n, m, newColor, oldColor);
    }

    public int[][] floodFill(int[][] img, int sr, int sc, int newColor) {
        int n = img.length;
        int m = img[0].length;

        // Store the original color of the starting pixel
        int oldColor = img[sr][sc];

        // If the newColor is the same as the oldColor, no need to flood fill
        if (oldColor != newColor) {
            dfs(img, sr, sc, n, m, newColor, oldColor);
        }

        return img;
    }
}
