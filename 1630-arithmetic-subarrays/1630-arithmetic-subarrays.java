class Solution {
 public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
           result.add(isArithmetic(nums, l[i], r[i]));
        }
        return result;
   }


   public boolean isArithmetic(int [] nums, int l, int r){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
       HashSet<Integer> st = new HashSet<>();

        for (int i = l; i <= r; i++) {
            max = Math.max(nums[i],max);        // max of nums
            min = Math.min(nums[i],min);        // min of nums
            st.add(nums[i]);
        }

        int len = r -l +1;
        // if (max-min)/(length-1) yields remainder = 0 => AP
        // else                                         => Not an AP

        if((max-min)%(len-1) !=0)               
            return false;

        int diff = (max-min)/(len-1);
        if(diff == 0)
            return true;

       int curr = min + diff;

        while (curr < max) {
            if (!st.contains(curr)) {
                return false;
            }
            curr += diff;
        }

        return true;
        
    } 
}