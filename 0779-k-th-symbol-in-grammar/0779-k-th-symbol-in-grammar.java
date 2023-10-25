class Solution {
    public int kthGrammar(int n, int k) {
        // Base case: When n is 1 and k is 1, return 0.
        if (n == 1 && k == 1) {
            return 0;
        }
        
        // Calculate the length of the current row using 2^(n-1).
        int length = (int) Math.pow(2, n - 1);
        
        // Calculate the mid-point of the row.
        int mid = (length / 2);
        
        // If k is less than or equal to the mid-point, recursively call kthGrammar on the previous row with the same k.
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        }
        
        // If k is greater than the mid-point, recursively call kthGrammar on the previous row with k adjusted by subtracting mid.
        return 1 - kthGrammar(n - 1, k - mid);
    }
}
