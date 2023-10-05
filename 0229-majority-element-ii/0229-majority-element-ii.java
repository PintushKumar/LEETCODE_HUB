class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // This is my Solution
       
        // List<Integer> res = new ArrayList<Integer>();
        // HashMap<Integer , Integer> mpp = new HashMap<>();
        // for(Integer ele : nums){
        //     mpp.put(ele ,mpp.getOrDefault(ele , 0)+1);
        //     if(mpp.get(ele)>nums.length/3  && !res.contains(ele)){
        //         res.add(ele);
        //     }
        // }
        // return res;


        List<Integer> res = new ArrayList<Integer>();
        int count1 =0 , count2 = 0 , num1 =-1 , num2 = -1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]== num1){
                count1++;
            }else if(nums[i]==num2){
                count2++;
            }
            else if(count1==0){
                num1=nums[i];
                count1 =1;
            }else if(count2 == 0){
                num2=nums[i];
                count2 =1;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1=0;
        count2=0;

        for(int i=0;i<n;i++){
            if(nums[i]==num1){
                count1++;
            }else if(nums[i]==num2){
                count2++;
            }
        }

        if(count1>n/3){
            res.add(num1);
        }
        if(count2>n/3){
            res.add(num2);
        }
        return res;
    }
}