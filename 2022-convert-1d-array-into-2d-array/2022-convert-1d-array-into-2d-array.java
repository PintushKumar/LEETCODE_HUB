class Solution {
    public int[][] construct2DArray(int[] arr, int n, int m) {
        int res[][] = new int [n][m];
        int l = arr.length;
        if (l != m * n) {
            return new int[0][0];
        }
        int indx =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]= arr[indx++];
            }
        }
        return res;
    }
}