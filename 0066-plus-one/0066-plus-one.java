class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(n==1){
            if(digits[0]==9){
                int res [] = new int [2];
                res[0]=1;
                res[1]=0;
                return res;
            }else{
                digits[0]+=1;
                return digits;
            }
        }
        
        if(digits[n-1]==9){
            int i = n-1;
            for(;i>=0;i--){
                if(digits[i]==9){
                    digits[i]=0;
                }else{
                    break;
                }
            }
           if(i<0){
               int res[] = new int [n+1];
               res[0]=1;
               return res;
           }else{
               digits[i]+=1;
               return digits;
           }
        }


        digits[n-1]+=1;
        return digits;
    }
}