class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String [] res = new String[names.length];
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>();

        for (int i = 0; i < names.length; i++) tm.put(heights[i], names[i]);

        

        int index = res.length - 1;
        for (Map.Entry<Integer, String> entry : tm.entrySet()) {
            res[index] = entry.getValue();
            index--;
        }
        return res;
    }
}