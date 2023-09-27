class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        long size = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size += 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= size;

            if (k == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }

            if (Character.isDigit(c)) {
                size /= (c - '0');
            } else {
                size -= 1;
            }
        }
        
        return "";
    }
}