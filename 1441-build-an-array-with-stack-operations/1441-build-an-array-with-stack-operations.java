class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int stream =1;
        int i=0;
       // res.add("push");
        while(i<target.length && stream <=n){
            res.add("Push");
            if(target[i]==stream){
                i++;
            }else{
                res.add("Pop");
            }
            stream++;
        }
        return res;
    }
}