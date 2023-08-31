class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length ==1){
            return intervals;
        }
        
        // Sort the starting intervals in ascending manner 
        Arrays.sort(intervals , Comparator.comparingInt( i->i[0]));
        
        List<int[]> result = new ArrayList<>();
        int newInterval[] = intervals[0];
        result.add(newInterval);
        for(int interval []: intervals){
            if(interval[0]<=newInterval[1]){
                // overlapping intervals update the end of the  intervals if  needed
                newInterval [1] = Math.max(newInterval[1] , interval[1]);
            }else{
                newInterval = interval;
                result.add(interval);
            }
        }
        return result.toArray(new int [result.size()][]);
    }
}