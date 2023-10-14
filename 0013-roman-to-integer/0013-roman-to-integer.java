// class Solution {
//     public int romanToInt(String s) {
//         HashMap<Character , Integer > map = new HashMap<>();
//         map.put('I' , 1);
//         map.put('V' , 5);
//         map.put('X' , 10);
//         map.put('L' , 50);
//         map.put('C' , 100);
//         map.put('D' , 500);
//         map.put('M' , 1000);
//         int n = s.length();
//         int sum =0;
//         for(int i=n-1;i>=1;i--){
//             int af = map.get(s.charAt(i-1));
//             int curr = map.get(s.charAt(i));
//             sum+= af<curr ? -af :af;
//         }
        
//         int af = map.get(s.charAt(0));
//         int curr = map.get(s.charAt(1));
//         sum+= af<curr ? -af :af;
//         return sum;
//     }
// }

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            int curr = map.get(s.charAt(i));
            int next = map.get(s.charAt(i + 1));
            if (curr < next) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }

        sum += map.get(s.charAt(n - 1));

        return sum;
    }
}
