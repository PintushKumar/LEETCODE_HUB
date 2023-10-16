class Solution {
    public List<Integer> getRow(int rowIndex) {
        
	    ArrayList<Integer> ans = new ArrayList<>();

        if(rowIndex ==0){
            ans.add(1);
            return ans;
        }

        List<List<Integer>> triangle = new ArrayList<>();
        for(int i=0;i<rowIndex+1;i++){
            List<Integer> triangleRow = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i ){
                    triangleRow.add(1);
                }else{
                    int aboveTwoSum = (triangle.get(i-1).get(j)+triangle.get(i-1).get(j-1));
                    triangleRow.add(aboveTwoSum);
                }
            }
            triangle.add(triangleRow);
        }
        
        int size = triangle.size();
        List<Integer> row = triangle.get(size-1);
        ans.addAll(row);
        
        return ans;
    }
}