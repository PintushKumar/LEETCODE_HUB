class Solution {
   public int maximumScore(int[] A, int k) {
        int res = A[k], mini = A[k], i = k, j = k, n = A.length;
        while (i > 0 || j < n - 1) {
            if (i == 0)
                ++j;
            else if (j == n - 1)
                --i;
            else if (A[i - 1] < A[j + 1])
                ++j;
            else
                --i;
            mini = Math.min(mini, Math.min(A[i], A[j]));
            res = Math.max(res, mini * (j - i + 1));
        }
        return res;
    }
}