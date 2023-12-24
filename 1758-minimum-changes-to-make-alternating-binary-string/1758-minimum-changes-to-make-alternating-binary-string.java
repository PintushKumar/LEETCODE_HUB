class Solution {
    public int minOperations(String s) {
          int res = 0;
        if (s == null || s.length() == 0) 
            return 0;
        char[] c = s.toCharArray();
        char next = c[0] == '0' ? '1' : '0';
        for (int i = 1; i < c.length; i++) {
            if (c[i] != next) {
                res++;
            }
            next = next == '0' ? '1' : '0';

        } 
        return Math.min(res, c.length - res);
    }
}